package be.BiscontiLagneau.DAO;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import be.BiscontiLagneau.Enum.*;
import be.BiscontiLagneau.JavaBean.*;
//
//
// Ce sont les appels aux RPC qui doivent se trouver ici
// Les connections à la base de données se font dans le Rest_Examen
// J'ai créé les packages, classes , etc .. nécessaires dans le Rest_Examen
// Pas oublier , que dans le Rest_Examen, c'est des appels à des procédures stockées dans la BDD
public class DAOMedecin extends DAO<CMedecin>{
	public DAOMedecin(){}
	/*
	public CMedecin getMedecin(int inami, String mdp)
	{
		
		CMedecin medecin = null;
        try
        {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY	).executeQuery("SELECT * FROM Medecins M "
                    		+ "INNER JOIN Personnes P ON P.id_personne = M.id_personne "
                    		+ "WHERE num_inami = " + inami + " AND mdp = '" + mdp + "'");

            while(result.next())
            {
            	medecin = new CMedecin();
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setAdresse(result.getString("adresse"));
                //medecin.setDateNaissance(result.getDate("naissance"));
                //medecin.setDateDiplome(result.getDate("date_diplome "));
                medecin.setInami(result.getInt("inami"));
                medecin.setAdresseCabinet(result.getString("adresse_cabinet"));
                medecin.setTelephone(result.getString("telephone"));
                //sexe
                
                switch(result.getString("specialisation "))
                {
                	case "Cardiologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Cardiologie);
                		break;
                	}
                	case "Dermatologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Dermatologie);
                		break;
                	}
                	case "Generale" :
                	{
                		medecin.setSpecialisation(Specialisation.Generale);
                		break;
                	}
                	case "Gynecologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Gynecologie);
                		break;
                	}
                	case "Neurologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Neurologie);
                		break;
                	}
                	case "Ophtalmologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Ophtalmologie);
                		break;
                	}
                	case "Psychiatre" :
                	{
                		medecin.setSpecialisation(Specialisation.Psychiatre);
                		break;
                	}
                	case "Pneumologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Pneumologie);
                		break;
                	}
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return medecin;
	}*/

	@Override
	public boolean ajouter(CMedecin obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(CMedecin obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifier(CMedecin obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public CMedecin chercher(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public CMedecin authentification(long inami, String mdp) {
		CMedecin medecin = new CMedecin();
		ClientConfig config = new DefaultClientConfig();
		Client c = Client.create(config);
		WebResource webResource = c.resource(DAOConnexion.getbaseURI());
		
		if (webResource.equals(null)) {
			System.out.println("Aucune réponse");
		}
		
		String jsonResponse = webResource	.path("Medecin/authentification")
											.queryParam("inami",String.format("%d", inami))
											.queryParam("mdp", mdp)
											.accept(MediaType.APPLICATION_JSON)
											.get(String.class);
		
		try {
			JSONObject json = new JSONObject(jsonResponse);
			
			medecin.setID_Medecin(json.getInt("ID_Personne"));
			medecin.setNom(json.getString("nom"));
			medecin.setPrenom(json.getString("prenom"));
			medecin.setAdresse(json.getString("adresse"));
			medecin.setDateNaissance(LocalDate.parse(json.getString("dateNaissance")));
			medecin.setSexe(Genre.fromString(json.getString("sexe")));
			medecin.setTelephone(json.getString("telephone"));
			medecin.setAdresseCabinet(json.getString("adresseCabinet"));
			medecin.setDateDiplome(LocalDate.parse(json.getString("dateDiplome")));
			medecin.setInami(json.getLong("inami"));
			medecin.setSpecialisation(Specialisation.fromString(json.getString("specialisation").toLowerCase()));
			return medecin;
		} 
		catch (JSONException e) {
			e.printStackTrace();
			return null;
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
		catch (JsonSyntaxException  e) {
			e.printStackTrace();
			return null;
		}
		catch(IllegalStateException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<CMedecin> recupererTout() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
