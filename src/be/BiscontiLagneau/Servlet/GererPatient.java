package be.BiscontiLagneau.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.BiscontiLagneau.JavaBean.*;

/**
 * Servlet implementation class GererPatient
 */
@WebServlet("/GererPatient")
public class GererPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<String> ListPatients = new ArrayList<String>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GererPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// R�cup�rer la liste des patients et les placer dans le request pour l'affichage
				CPatient cPatient = new CPatient();
				List<CPatient> ListPatients = cPatient.recupererTousPatients();
				request.setAttribute("ListPatients", ListPatients);
				
				//R�cup�ration des champs du formulaire de recherche si on a appuyer sur le bouton
				if(request.getParameter("Rechercher") != null) {
					//Les champs r�cup�r�s sont mis en lowercase et on rajoute un champ vide 
					String nom 	= request.getParameter("nom").toString().toLowerCase().concat("");
					String prenom = request.getParameter("prenom").toString().toLowerCase().concat("");
					String nrn = request.getParameter("nrn").toString().toLowerCase().concat("");
					//transformations de la liste en Stream	
					Stream<CPatient> StreamPatients = ListPatients.stream();
					// le champ vide rajout� pr�c�dement permet d'utiliser quand m�me le startWith pour une recherche plus ergonomique
					List<CPatient> ListPatientTrier = StreamPatients.filter(m -> m.getNom().toLowerCase().startsWith(nom) && m.getPrenom().toLowerCase().startsWith(prenom) && String.valueOf(m.getNrn()).toLowerCase().startsWith(nrn) ).collect(Collectors.toList());
					request.setAttribute("ListPatients", ListPatientTrier);
				}
				if (request.getParameter("infoSup") != null) {
					String IDPatient = request.getParameter("infoSup");		
					CPatient cPatient2 = new CPatient();
					cPatient2 = cPatient2.chercher(Integer.parseInt(IDPatient));
					request.setAttribute("Patient", cPatient2);
					getServletContext().getRequestDispatcher("/Vues/FicheInfoPatient.jsp").forward(request, response);
				}
				
				// On v�rifie si on � cliquer sur le bouton, et si oui, on r�cup�re l'id du patient pour l'envoyer sur la page du traitement m�dical
				if (request.getParameter("Selectionner") != null) {
					HttpSession session = request.getSession();
					String IDPatient = request.getParameter("Selectionner");
					session.setAttribute("PatientChoisi", IDPatient);
					getServletContext().getRequestDispatcher("/Traitement").forward(request, response);
				}
				getServletContext().getRequestDispatcher("/Vues/ListePatients.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
