package be.BiscontiLagneau.JavaBean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import be.BiscontiLagneau.DAO.*;
import be.BiscontiLagneau.Enum.*;

public class CMedecin extends CPersonne implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// Attributs
	private int ID_Medecin;
	private String mdp;
	private List<CTraitement> l_Traitements;
	private long inami;
	private String adresseCabinet;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate dateDiplome;
	private Specialisation specialisation;

	// Constructeur
	public CMedecin() {
	}
	
	
	public CMedecin(String nom, String prenom, LocalDate dateNaissance, String telephone, Genre sexe,
			String adresse,int ID_Medecin, String mdp, List<CTraitement> l_Traitements, long inami, String adresseCabinet,
			LocalDate dateDiplome, Specialisation specialisation) {
		super( nom, prenom, dateNaissance, telephone, sexe, adresse);
		this.mdp = mdp;
		this.l_Traitements = l_Traitements;
		this.inami = inami;
		this.adresseCabinet = adresseCabinet;
		this.dateDiplome = dateDiplome;
		this.specialisation = specialisation;
	}


	//Méthodes
	public CMedecin authentification (long inami, String mdp) {
		DAOMedecin daoM = new DAOMedecin();
		return daoM.authentification(inami, mdp);
	}
	
	

	@Override
	public String toString() {
		return "CMedecin [mdp=" + mdp + ", l_Traitements=" + l_Traitements + ", inami=" + inami + ", adresseCabinet="
				+ adresseCabinet + ", dateDiplome=" + dateDiplome + ", specialisation=" + specialisation
				+ ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateNaissance + ", telephone=" + telephone + ", sexe=" + sexe + ", adresse=" + adresse + "]";
	}


	// Accesseurs
	public int getID_Medecin() {
		return ID_Medecin;
	}


	public void setID_Medecin(int ID_Medecin) {
		this.ID_Medecin = ID_Medecin;
	}
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public List<CTraitement> getL_Traitements() {
		return l_Traitements;
	}

	public void setL_Traitements(List<CTraitement> l_Traitements) {
		this.l_Traitements = l_Traitements;
	}

	public String getAdresseCabinet() {
		return adresseCabinet;
	}

	public void setAdresseCabinet(String adresseCabinet) {
		this.adresseCabinet = adresseCabinet;
	}

	public LocalDate getDateDiplome() {
		return dateDiplome;
	}

	public void setDateDiplome(LocalDate dateDiplome) {
		this.dateDiplome = dateDiplome;
	}

	public Specialisation getSpecialisation() {
		return specialisation;
	}

	public void setSpecialisation(Specialisation specialisation) {
		this.specialisation = specialisation;
	}
	
	public void setInami(long inami)
	{
		this.inami = inami;
	}
	
	public long getInami()
	{
		return inami;
	}


	
}
