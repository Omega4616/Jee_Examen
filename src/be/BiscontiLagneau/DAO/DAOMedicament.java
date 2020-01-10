package be.BiscontiLagneau.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
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
		CMedicament Medicament = new CMedicament();
		ClientConfig config = new DefaultClientConfig();
		Client c = Client.create(config);
		WebResource webResource = c.resource(DAOConnexion.getbaseURI());
		
		if (webResource.equals(null)) {
			System.out.println("Aucune réponse");
		}
		
		String jsonResponse = webResource	.path("Medicament/chercherMedicament")
											.queryParam("IDMedicament", String.format("%d",id))
											.accept(MediaType.APPLICATION_JSON)
											.get(String.class);
		
		try {
			Gson gson= new Gson();
			Medicament = gson.fromJson(jsonResponse, CMedicament.class);
			return Medicament;
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
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
		
		try {
			Gson gson= new Gson();
			ListeMedicaments = gson.fromJson(jsonResponse, new TypeToken<ArrayList<CMedicament>>() {}.getType());
			//Ne fonctionne pas avec ObjectMapper(n'attribue pas de valeur aux ID_Medicament), j'ai donc remplacé par la solution de Google qui est lui fonctionnel et bien à jour
			//ListeMedicaments = mapper.readValue(jsonResponse, new TypeReference<ArrayList<CMedicament>>(){});		
			//ListeMedicaments = Arrays.asList(mapper.readValue(jsonResponse, CMedicament[].class));
			return ListeMedicaments;
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			return null;
		}
	}

}
