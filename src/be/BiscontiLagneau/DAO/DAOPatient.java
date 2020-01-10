package be.BiscontiLagneau.DAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import be.BiscontiLagneau.Enum.Genre;
import be.BiscontiLagneau.JavaBean.CMedecin;
import be.BiscontiLagneau.JavaBean.CMedicament;
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
		CPatient patient = new CPatient();
		ClientConfig config = new DefaultClientConfig();
		Client c = Client.create(config);
		WebResource webResource = c.resource(DAOConnexion.getbaseURI());
		
		if (webResource.equals(null)) {
			System.out.println("Aucune réponse");
		}
		
		String jsonResponse = webResource	.path("Patient/chercherPatient")
											.queryParam("IDPatient",String.format("%d", id))
											.accept(MediaType.APPLICATION_JSON)
											.get(String.class);
		
		try {
			JSONObject json = new JSONObject(jsonResponse);
			
			patient.setID_Patient(json.getInt("ID_Patient"));
			patient.setNom(json.getString("nom"));
			patient.setPrenom(json.getString("prenom"));
			patient.setAdresse(json.getString("adresse"));
			patient.setDateNaissance(LocalDate.parse(json.getString("dateNaissance")));
			patient.setSexe(Genre.fromString(json.getString("sexe")));
			patient.setTelephone(json.getString("telephone"));
			patient.setNrn(json.getLong("nrn"));
			return patient;
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
	public List<CPatient> recupererTout() {
		ArrayList<CPatient> ListePatients = new ArrayList<CPatient>();
		ClientConfig config = new DefaultClientConfig();
		Client c = Client.create(config);
		WebResource webResource = c.resource(DAOConnexion.getbaseURI());
		
		if (webResource.equals(null)) {
			System.out.println("Aucune réponse");
		}
		
		String jsonResponse = webResource	.path("Patient/recupTousPatients")
											.accept(MediaType.APPLICATION_JSON)
											.get(String.class);
		//ObjectMapper mapper = new ObjectMapper();
		
		try {
			//ListePatients = mapper.readValue(jsonResponse, new TypeReference<ArrayList<CPatient>>(){});
			JSONArray array = new JSONArray(jsonResponse);
			
			for (int i = 0; i < array.length(); i++) {
				JSONObject jo = array.getJSONObject(i);
				CPatient p = new CPatient();
				p.setID_Patient(jo.getInt("ID_Patient"));
				p.setNom(jo.getString("nom"));
				p.setPrenom(jo.getString("prenom"));
				p.setAdresse(jo.getString("adresse"));
				p.setDateNaissance(LocalDate.parse(jo.getString("dateNaissance")));
				p.setSexe(Genre.fromString(jo.getString("sexe")));
				p.setTelephone(jo.getString("telephone"));
				p.setNrn(jo.getLong("nrn"));
				ListePatients.add(p);
			}
			/*
			Gson gson= new GsonBuilder()
					   .setDateFormat("yyyy-mm-dd").create();
			ListePatients = gson.fromJson(jsonResponse, new TypeToken<List<CPatient>>() {}.getType());*/
			return ListePatients;
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
}
