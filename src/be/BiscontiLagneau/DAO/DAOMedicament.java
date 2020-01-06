package be.BiscontiLagneau.DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import be.BiscontiLagneau.JavaBean.CMedecin;
import be.BiscontiLagneau.JavaBean.CMedicament;

public class DAOMedicament extends DAO<CMedicament> {

	@Override
	public boolean ajouter(CMedicament obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(CMedicament obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifier(CMedicament obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CMedicament chercher(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CMedicament> recupererTout() {
		List<CMedicament> ListeMedicaments = new ArrayList<CMedicament>();
		ClientConfig config = new DefaultClientConfig();
		Client c = Client.create(config);
		WebResource webResource = c.resource(DAOConnexion.getbaseURI());
		
		if (webResource.equals(null)) {
			System.out.println("Aucune réponse");
		}
		
		String jsonResponse = webResource	.path("Medicament/recupTousMedicaments")
											.accept(MediaType.APPLICATION_JSON)
											.get(String.class);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			ListeMedicaments = Arrays.asList(mapper.readValue(jsonResponse, CMedicament[].class));
			return ListeMedicaments;
		} 
		catch (JsonParseException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		catch (JsonMappingException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
