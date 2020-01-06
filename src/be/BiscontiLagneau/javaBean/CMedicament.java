package be.BiscontiLagneau.JavaBean;

import java.io.Serializable;
import java.util.ArrayList;

import be.BiscontiLagneau.JavaBean.CMedicament;

public class CMedicament implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// Attributs
	private String nom;
	private String type;
	private String description;
	private String dosage_jour_max;

	// Constructeurs
	public CMedicament() {

	}

	public CMedicament(String nom, String type, String description, String dosage_jour_max) {
		super();
		this.nom = nom;
		this.type = type;
		this.description = description;
		this.dosage_jour_max = dosage_jour_max;
	}
	
	//Méthodes
	
	public ArrayList<CMedicament> recupererTousMedicaments(){
		
		return null;
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

	public String getDosage_jour_max() {
		return dosage_jour_max;
	}

	public void setDosage_jour_max(String dosage_jour_max) {
		this.dosage_jour_max = dosage_jour_max;
	}
}
