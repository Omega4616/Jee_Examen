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
				List<CPatient> ListPatients = cPatient.recupererTousMedicaments();
				CMedicament cMedicament = new CMedicament();
				List<CMedicament> medicaments = cMedicament.recupererTousMedicaments();
				request.setAttribute("medicaments", medicaments);
				
				//R�cup�ration des champs du formulaire de recherche si on a appuyer sur le bouton
				if(request.getParameter("Rechercher") != null) {
					//Les champs r�cup�r�s sont mis en lowercase et on rajoute un champ vide 
					String nom 	= request.getParameter("nom").toString().toLowerCase().concat("");
					String type = request.getParameter("type").toString().toLowerCase().concat("");
					//transformations de la liste en Stream	
					Stream<CMedicament> StreamMedi = medicaments.stream();
					// le champ vide rajout� pr�c�dement permet d'utiliser quand m�me le startWith pour une recherche plus ergonomique
					List<CMedicament> ListMediTrier = StreamMedi.filter(m -> m.getNom().toLowerCase().startsWith(nom) && m.getType().toLowerCase().startsWith(type)).collect(Collectors.toList());
					request.setAttribute("medicaments", ListMediTrier);
				}
				
				// On v�rifie si on � cliquer sur le bouton, et si oui, on r�cup�re l'id du m�dicament et on l'ajoute � la liste
				if (request.getParameter("Choisir") != null) {
					HttpSession session = request.getSession();
					List_IdMedicament.add(request.getParameter("Choisir"));
					session.setAttribute("List_IdMedicament", List_IdMedicament);
				}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
