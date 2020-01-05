package be.BiscontiLagneau.DAO;

import java.net.URI;
import javax.ws.rs.core.UriBuilder;

public class DAOConnexion {

    private DAOConnexion(){}
    public static URI getbaseURI() {
    	URI url;
    	try {
			url = UriBuilder.fromUri("http://localhost:9090/Rest_Examen/rest/").build();
		} catch (IllegalArgumentException e) {
			url = null;
		}
    	return url;
    }
    
}
