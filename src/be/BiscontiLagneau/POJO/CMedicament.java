package be.BiscontiLagneau.POJO;

import java.io.Serializable;

public class CMedicament implements Serializable {
	// Attributs
	private String nom;
	private String type;
	private String description;
	private String posologieMax;

	// Constructeurs
	public CMedicament() {

	}

	public CMedicament(String nom, String type, String description, String posologieMax) {
		super();
		this.nom = nom;
		this.type = type;
		this.description = description;
		this.posologieMax = posologieMax;
	}

	// Accesseurs
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPosologieMax() {
		return posologieMax;
	}

	public void setPosologieMax(String posologieMax) {
		this.posologieMax = posologieMax;
	}
}
