package be.BiscontiLagneau.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.BiscontiLagneau.Enum.Genre;
import be.BiscontiLagneau.Enum.Specialisation;
import be.BiscontiLagneau.JavaBean.CMedecin;

@WebServlet("/ServletInscriptionMedecin")
public class ServletInscriptionMedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String urlErreurs;
	
    public ServletInscriptionMedecin() {
    	super();
    }

    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
        urlErreurs = config.getInitParameter("urlErreurs");
     }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inami = request.getParameter("inami");
		String mdp1 = request.getParameter("mdp1");
		String mdp2 = request.getParameter("mdp2");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String adresseCabinet = request.getParameter("adresseCabinet");
		String telephone = request.getParameter("telephone");
		String naissanceJ = request.getParameter("naissanceJ");
		String naissanceM = request.getParameter("naissanceM");
		String naissanceA = request.getParameter("naissanceA");
		String diplomeJ = request.getParameter("diplomeJ");
		String diplomeM = request.getParameter("diplomeM");
		String diplomeA = request.getParameter("diplomeA");
		String spe = request.getParameter("spe");
		String genre = request.getParameter("genre");
		
		LocalDate dateNaissance = null;
		LocalDate dateDiplome = null;
		Specialisation specialisation = null;
		Genre sexe = null;
		
		int anneeNaissance = 0;
		
		ArrayList<String> erreurs = new ArrayList<>();
		
		if (request.getParameter("inscription") != null) 
		{
			if(inami.length() != 11) erreurs.add(getInitParameter("ErreurInami"));
			
			if(mdp1.length() < 3 || mdp1.length() > 15) erreurs.add(getInitParameter("ErreurMdp"));
			else if(!mdp1.equals(mdp2)) erreurs.add(getInitParameter("ErreurConf"));
			
			if(nom.length() < 3 || nom.length() > 15) erreurs.add(getInitParameter("ErreurNom"));
			
			if(prenom.length() < 3 || prenom.length() > 15) erreurs.add(getInitParameter("ErreurPrenom"));
			
			if(adresse.length() < 10 || adresse.length() > 30) erreurs.add(getInitParameter("ErreurAdresse"));
			if(adresseCabinet.length() < 10 || adresseCabinet.length() > 30) erreurs.add(getInitParameter("ErreurAdresseCabinet"));
			
			if(naissanceJ.length() != 2 || naissanceM.length() != 2 || naissanceA.length() != 2) erreurs.add(getInitParameter("ErreurNaissance"));
			else
			{
				try
				{
					int j, m;
					j = Integer.parseInt(naissanceJ);
					m = Integer.parseInt(naissanceM);
					anneeNaissance = Integer.parseInt(naissanceA);
					
					dateNaissance = LocalDate.now();
					//if(anneeNaissance < 1990) dateNaissance = new LocalDate(anneeNaissance, m, j);
					//else erreurs.add(getInitParameter("ErreurNaissance2"));
				}
				catch(Exception e)
				{
					erreurs.add(getInitParameter("ErreurNaissance2"));
				}
			}		
			
			if(diplomeJ.length() != 2 || diplomeM.length() != 2 || diplomeA.length() != 2) erreurs.add(getInitParameter("ErreurDiplome"));
			else
			{
				try
				{
					int j, m, a;
					j = Integer.parseInt(diplomeJ);
					m = Integer.parseInt(diplomeM);
					a = Integer.parseInt(diplomeA);
					
					dateDiplome = LocalDate.now();
					//if(a >= anneeNaissance + 20) dateDiplome = new LocalDate(a, m, j);
					//else erreurs.add(getInitParameter("ErreurDiplome2"));
				}
				catch(Exception e)
				{
					erreurs.add(getInitParameter("ErreurDiplome2"));
				}
			}	
			
			if(telephone.length() != 10) erreurs.add(getInitParameter("ErreurTelephone"));
				
			if(spe != null)
			{
				switch(spe)
				{
					case "Cardiologie" :
					{
						specialisation = Specialisation.Cardiologie;
						break;
					}
					case "Generale" :
					{
						specialisation = Specialisation.Generale;
						break;
					}
					case "Pneumologie" :
					{
						specialisation = Specialisation.Pneumologie;
						break;
					}
					case "Neurologie" :
					{
						specialisation = Specialisation.Neurologie;
						break;
					}
					case "Ophtalmologie" :
					{
						specialisation = Specialisation.Ophtalmologie;
						break;
					}
					case "Psychiatre" :
					{
						specialisation = Specialisation.Psychiatre;
						break;
					}
					case "Dermatologie" :
					{
						specialisation = Specialisation.Dermatologie;
						break;
					}
					case "Gynecologie" :
					{
						specialisation = Specialisation.Gynecologie;
						break;
					}
				}
			}
			else erreurs.add(getInitParameter("ErreurSpe"));
			
			if(genre != null)
			{
				switch(genre)
				{
					case "Homme" :
					{
						sexe = Genre.Homme;
						break;
					}
					case "Femme" :
					{
						sexe = Genre.Femme;
						break;
					}
				}
			}
			else erreurs.add(getInitParameter("ErreurGenre"));
			
			if(erreurs.size() == 0)
			{
				CMedecin medecin = new CMedecin(nom,prenom,dateNaissance, telephone, sexe, adresse, mdp1, Long.parseLong(inami), adresseCabinet, dateDiplome, specialisation);
				medecin.inscrireMedecin();
			}
			else
			{
				/*PrintWriter out=response.getWriter();
				for(String s : erreurs)
				{
					out.println(s);
				}*/
				
				request.setAttribute("erreurs", erreurs);
	        	getServletContext().getRequestDispatcher(urlErreurs).forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
