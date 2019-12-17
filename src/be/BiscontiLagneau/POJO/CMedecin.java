package be.BiscontiLagneau.POJO;

import java.time.LocalDate;
import java.util.List;

import be.BiscontiLagneau.Enum.Specialisation;

public class CMedecin extends CPersonne {
	// Attributs
	private String mdp;
	private List<CTraitement> l_Traitements;
	private String adresseCabinet;
	private LocalDate dateDiplome;
	private Specialisation specialisation;

	// Constructeur
	public CMedecin() {
	}

	public CMedecin(String mdp, List<CTraitement> l_Traitements, String adresseCabinet, LocalDate dateDiplome,
			Specialisation specialisation) {
		super();
		this.mdp = mdp;
		this.l_Traitements = l_Traitements;
		this.adresseCabinet = adresseCabinet;
		this.dateDiplome = dateDiplome;
		this.specialisation = specialisation;
	}

	// Accesseurs
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
}
