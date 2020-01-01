package be.BiscontiLagneau.POJO;

import java.io.Serializable;
import java.time.LocalDate;

import be.BiscontiLagneau.Enum.Prise;

public class CCure implements Serializable{
	// Attributs
	private LocalDate dateDebut;
	private int duree;
	private CMedicament medicament;
	private Prise prise;
	private int posologie; // en mg
	// Constructeurs

	public CCure() {

	}

	public CCure(LocalDate dateDebut, int duree, CMedicament medicament, Prise prise, int posologie) {
		super();
		this.dateDebut = dateDebut;
		this.duree = duree;
		this.medicament = medicament;
		this.prise = prise;
		this.posologie = posologie;
	}

	// Accesseurs
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public CMedicament getMedicament() {
		return medicament;
	}

	public void setMedicament(CMedicament medicament) {
		this.medicament = medicament;
	}

	public Prise getPrise() {
		return prise;
	}

	public void setPrise(Prise prise) {
		this.prise = prise;
	}

	public int getPosologie() {
		return posologie;
	}

	public void setPosologie(int posologie) {
		this.posologie = posologie;
	}

}
