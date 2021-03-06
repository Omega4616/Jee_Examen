package be.BiscontiLagneau.JavaBean;

import java.io.Serializable;
import java.util.List;

import be.BiscontiLagneau.DAO.DAOMedicament;
import be.BiscontiLagneau.JavaBean.CMedicament;

public class CMedicament implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// Attributs
	private int ID_Medicament;
	private String nom;
	private String type;
	private String description;
	private String dosage_jour_max;

	// Constructeurs
	public CMedicament() {}

	public CMedicament(int ID_Medicament, String nom, String type, String description, String dosage_jour_max) {
		this.ID_Medicament = ID_Medicament;
		this.nom = nom;
		this.type = type;
		this.description = description;
		this.dosage_jour_max = dosage_jour_max;
	}
	
	//M�thodes
	
	public List<CMedicament> recupererTousMedicaments(){
		DAOMedicament daoMedicament = new DAOMedicament();
		return daoMedicament.recupererTout();
	}
	public CMedicament chercher(int id) {
		DAOMedicament daoMedicament = new DAOMedicament();
		return daoMedicament.chercher(id);
	}
	
	// Accesseurs
	public int getID_Medicament() {  
		return ID_Medicament;
	}

	public void setID_Medicament(int ID_Medicament) {
		this.ID_Medicament = ID_Medicament;
	}
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
