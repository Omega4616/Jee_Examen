package be.BiscontiLagneau.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.BiscontiLagneau.DAO.DAO;
import be.BiscontiLagneau.DAO.DAOConnexion;
import be.BiscontiLagneau.DAO.DAOMedecin;
import be.BiscontiLagneau.javaBean.CMedecin;
//import betaboutique.javabean.Client;    Attention avec tes copier/coller, et push sur le git alors que l'IDE révèle des problème n'est vraiment pas une bonne idée ....
//import betaboutique.servlet.client.HttpSession;

//@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String inami, mdp;
	CMedecin medecin;

    public ServletConnexion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		inami=request.getParameter("inami");           
		mdp=request.getParameter("mdp");
		medecin = null;
        
        boolean ok = true;
            
        ArrayList<String> erreurs = new ArrayList<>();
        
        if(inami.length() != 11)
        {
        	erreurs.add(getInitParameter("ErreurInami"));
        	ok = false;
        }
        else
        {
        	//DAOMedecin dao = new DAOMedecin(DAOConnexion.getInstance());
        	//medecin = dao.getMedecin(inami, mdp);
        	
        	if(medecin == null)
        	{
        		erreurs.add(getInitParameter("ErreurMedecin"));
        		ok = false;
        	}
        }
        
        if(mdp.length() < 5)
        {
        	erreurs.add(getInitParameter("ErreurMdp"));
        }
        
        if(ok)
        {                         
        	request.setAttribute("medecin", medecin);
            
            //getServletContext().getRequestDispatcher(UrlConnexionOk).forward(request, response);
        }
        else
        {
        	request.setAttribute("medecin", medecin);
        	request.setAttribute("erreurs", erreurs);
        	//getServletContext().getRequestDispatcher(UrlConnexionErreur).forward(request, response);
        }  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
