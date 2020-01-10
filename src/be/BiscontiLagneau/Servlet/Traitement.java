package be.BiscontiLagneau.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import be.BiscontiLagneau.JavaBean.*;

/**
 * Servlet implementation class Traitement
 */
@WebServlet("/Traitement")
public class Traitement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Traitement() {
        super();
        // TODO Auto-generated constructor stub
    }
//
//
    //
    //
    // Implémentation de la fiche de traitement du patient non fini
    //
    //
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		CPatient p = new CPatient();
		CPatient patient = new CPatient();
		if(session.getAttribute("PatientChoisi") != null) {
			int ID_Patient = Integer.parseInt(session.getAttribute("PatientChoisi").toString()) ;
			patient = p.chercher(ID_Patient);
			request.setAttribute("Patient", patient);
			/*
			ArrayList<String> List_IdMedicament = (ArrayList<String>) session.getAttribute("medicaments");
			CMedicament m = new CMedicament();
			List<CMedicament> medicaments = new ArrayList<CMedicament>();
			for (String id : List_IdMedicament) {
				medicaments.add(m.chercher(Integer.parseInt(id)));
			}
			request.setAttribute("medicaments", medicaments);*/
		}
		getServletContext().getRequestDispatcher("/Vues/Traitement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
