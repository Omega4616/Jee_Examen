package be.BiscontiLagneau.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.BiscontiLagneau.javaBean.CMedecin;

/**
 * Servlet implementation class AuthentificationMedecin
 */
@WebServlet("/AuthentificationMedecin")
public class AuthentificationMedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String emailAdmin = null;
	String urlBienvenue = null;
	String urlErreurs = null;

	public void init() {
		ServletConfig config = getServletConfig();
		urlErreurs = (String) config.getInitParameter("urlErreurs");
		urlBienvenue = (String) config.getInitParameter("urlBienvenue");
		// Récupérer email admin
		ServletContext servletContext = getServletContext();
		emailAdmin = servletContext.getInitParameter("emailAdministrateur");

	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthentificationMedecin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String inami = request.getParameter("inami");
		String mdp = request.getParameter("mdp");

		ArrayList<String> erreursParametres = new ArrayList<String>();
		
		if (request.getParameter("Connexion") != null) {
			
			if (inami == null) {
				erreursParametres.add("Le paramètre [inami] est null");
			}
			if (inami.equals("")) {
				erreursParametres.add("Le paramètre [inami] est vide");
			}
			if (!inami.matches("^[0-9a-zA-Z]{5,}$")) {
				erreursParametres.add("Le paramètre [inami] doit avoir minimum 5 caractères");
			}
			if (mdp == null) {
				erreursParametres.add("Le paramètre [mot de passe] est null");
			}
			if (mdp.equals("")) {
				erreursParametres.add("Le paramètre [mot de passe] est vide");
			}
			if (!mdp.matches("^[0-9a-zA-Z]{3,}$")) {
				erreursParametres.add("Le paramètre [mot de passe] doit avoir minimum 5 caractères");
			}

			if (inami != null && mdp != null) {
				CMedecin medecin = new CMedecin();
				Long num_inami = Long.parseLong(inami);
				medecin = medecin.authentification(num_inami, mdp);
				if (medecin == null) {
					erreursParametres.add("Identifiant incorrect");
					PrintWriter out = response.getWriter();
					response.setContentType("text/html");
					out.println("Identifiant incorrect");
				} else {
					PrintWriter out = response.getWriter();
					response.setContentType("text/html");
					out.println("<p>Vous êtes connecté</p>");
					
					HttpSession session = request.getSession();
					session.setAttribute("inami", medecin.getInami()); 
					session.setAttribute("Nom", medecin.getNom());
					
					//request.getRequestDispatcher(urlBienvenue).forward(request, response);
					getServletContext().getRequestDispatcher("/Vues/Bienvenue.jsp").forward(request, response);
				}
			}

			if (erreursParametres.size() > 0) {
				request.setAttribute("erreurs", erreursParametres);
				getServletContext().getRequestDispatcher(urlErreurs).forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
