package be.BiscontiLagneau.json.response;

public class codeResponse {
	//Attributs
	private int reponse;
	
	//Constructeur
	public codeResponse() {}
	public codeResponse(int code) {this.reponse = code;}

	
	//Accesseurs
	public int getReponse() {
		return reponse;
	}

	public void setReponse(int reponse) {
		this.reponse = reponse;
	}

}
