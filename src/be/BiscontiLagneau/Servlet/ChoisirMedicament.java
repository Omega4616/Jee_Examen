package be.BiscontiLagneau.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.BiscontiLagneau.JavaBean.CMedicament;

/**
 * Servlet implementation class ChoisirMedicament
 */
@WebServlet("/ChoisirMedicament")
public class ChoisirMedicament extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ArrayList<String> List_IdMedicament = new ArrayList<String>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChoisirMedicament() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("Choisir") != null) {
			List_IdMedicament.add(request.getParameter("IDMedicament"));
			request.setAttribute("mChoisi", List_IdMedicament);
			request.getSession().removeAttribute("IDMedicament");
			request.removeAttribute("IDMedicament");
		}
		getServletContext().getRequestDispatcher("/ChercherMedicament").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
