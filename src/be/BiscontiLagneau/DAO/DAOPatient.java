package be.BiscontiLagneau.DAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import be.BiscontiLagneau.JavaBean.CPatient;
import be.BiscontiLagneau.json.response.codeResponse;

public class DAOPatient extends DAO<CPatient>{

	@Override
	public boolean ajouter(CPatient patient) {
		codeResponse estAjouter = new codeResponse();
		ClientConfig config = new DefaultClientConfig();
		Client c = Client.create(config);
		WebResource webResource = c.resource(DAOConnexion.getbaseURI());
		
		if (webResource.equals(null)) {
			System.out.println("Aucune réponse");
		}
		String jsonResponse = webResource	.path("Patient/ajouterPatient")
											.queryParam("nom", patient.getNom())
											.queryParam("prenom", patient.getPrenom())
											.queryParam("naissance", patient.getDateNaissance().toString())
											.queryParam("adresse", patient.getAdresse())
											.queryParam("nrn", String.format("%d",patient.getNrn()))
											.queryParam("sexe", patient.getSexe().toString().toLowerCase())
											.queryParam("telephone", patient.getTelephone())
											.accept(MediaType.APPLICATION_JSON)
											.get(String.class);
		
		try {
			Gson gson = new Gson();
			estAjouter = gson.fromJson(jsonResponse, codeResponse.class);
			if (estAjouter.getReponse() == 1) {
				return true;
			}
			else {
				return false;
			}
		}catch (NullPointerException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}catch (JSONException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean supprimer(CPatient obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifier(CPatient obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CPatient chercher(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CPatient> recupererTout() {
		// TODO Auto-generated method stub
		return null;
	}
}
