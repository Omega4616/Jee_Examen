package be.BiscontiLagneau.javaBean;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import be.BiscontiLagneau.Enum.Genre;

public abstract class CPersonne implements Serializable{
	// Attributs
	protected int ID_Personne;
	protected String nom;
	protected String prenom;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	protected LocalDate dateNaissance;
	protected String telephone;
	protected Genre sexe;
	protected String adresse;

	// Constructeurs
	
	public CPersonne() {

	}

	public CPersonne(int ID_Personne, String nom, String prenom, LocalDate dateNaissance, String telephone, Genre sexe, String adresse) {
		this.ID_Personne = ID_Personne;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.sexe = sexe;
		this.adresse = adresse;
	}
	
	public CPersonne(String nom, String prenom, LocalDate dateNaissance, String telephone, Genre sexe, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.sexe = sexe;
		this.adresse = adresse;
	}

	// Accesseurs
	public int getID_Personne() {
		return ID_Personne;
	}

	public void setID_Personne(int ID_Personne) {
		this.ID_Personne = ID_Personne;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Genre getSexe() {
		return sexe;
	}

	public void setSexe(Genre sexe) {
		this.sexe = sexe;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
