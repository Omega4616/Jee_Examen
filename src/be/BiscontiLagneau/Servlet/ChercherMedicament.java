package be.BiscontiLagneau.Servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import be.BiscontiLagneau.JavaBean.*;


/**
 * Servlet implementation class ChercherMedicament
 */
@WebServlet("/ChercherMedicament")
public class ChercherMedicament extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	String emailAdmin = null;

	public void init() {
		ServletConfig config = getServletConfig();
		// Récupérer email admin
		ServletContext servletContext = getServletContext();
		emailAdmin = servletContext.getInitParameter("emailAdministrateur");
		

	}
	
	
    public ChercherMedicament() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CMedicament cMedicament = new CMedicament();
		List<CMedicament> medicaments = cMedicament.recupererTousMedicaments();
		request.setAttribute("medicaments", medicaments);
		getServletContext().getRequestDispatcher("/Vues/chercherMedicament.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
