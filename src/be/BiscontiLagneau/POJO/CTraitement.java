package be.BiscontiLagneau.POJO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class CTraitement implements Serializable{
	// Attributs
	private LocalDate dateIntroduction;
	private String symptome;
	private List<CCure> l_cures;

	// Constructeur
	public CTraitement() {

	}

	public CTraitement(LocalDate dateIntroduction, String symptome, List<CCure> l_cures) {
		super();
		this.dateIntroduction = dateIntroduction;
		this.symptome = symptome;
		this.l_cures = l_cures;
	}

//Accesseurs
	public LocalDate getDateIntroduction() {
		return dateIntroduction;
	}

	public void setDateIntroduction(LocalDate dateIntroduction) {
		this.dateIntroduction = dateIntroduction;
	}

	public String getSymptome() {
		return symptome;
	}

	public void setSymptome(String symptome) {
		this.symptome = symptome;
	}

	public List<CCure> getL_cures() {
		return l_cures;
	}

	public void setL_cures(List<CCure> l_cures) {
		this.l_cures = l_cures;
	}
}
