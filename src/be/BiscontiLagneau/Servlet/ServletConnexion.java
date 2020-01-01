package be.BiscontiLagneau.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String inami, mdp;

    public ServletConnexion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		inami=request.getParameter("inami");           
		mdp=request.getParameter("mdp");
        
        boolean ok = true;
            
        ArrayList<String> erreurs = new ArrayList<>();
        
        if(inami.length() != 11)
        {
        	erreurs.add(getInitParameter("ErreurInami"));
        	ok = false;
        }
        
        if(mdp.length() < 5)
        {
        	erreurs.add(getInitParameter("ErreurMdp"));
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
