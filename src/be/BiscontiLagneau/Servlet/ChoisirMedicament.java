package be.BiscontiLagneau.Servlet;

import java.io.IOException;
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
		if(request.getAttribute("Choisir") != null) {
			String IDMedicament = request.getParameter("ID_Medicament").toString();
			//CMedicament mChoisi = (CMedicament) request.getSession().getAttribute(medicamentChoisi);
			//request.getSession().removeAttribute(medicamentChoisi);
			//Object o = medicamentChoisi;
			//CMedicament m = (CMedicament)o;
			request.setAttribute("mChoisi", IDMedicament);
		}
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
