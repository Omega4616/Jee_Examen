package be.Lagneau.test;

import be.BiscontiLagneau.Enum.Genre;
import be.BiscontiLagneau.JavaBean.*;

import java.time.LocalDate;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*CMedecin m = new CMedecin();
		m = m.authentification(14689278354L, "test");*/
		
		//System.out.println(m.toString());
		
		//CMedicament cMedicament = new CMedicament();
		//List<CMedicament> cMedicaments = cMedicament.recupererTousMedicaments();
		//CPatient cPatient = new CPatient();
		/*List<CPatient> cpatients = new ArrayList<CPatient>();
		cpatients = cPatient.recupererTousPatients();
		for (CPatient patient : cpatients) {
			System.out.println("Nom :" + patient.getNom() + " Prenom : " + patient.getPrenom() + " Nrn : " + patient.getNrn() +  " ID : " + patient.getID_Patient() + " Genre : "+ patient.getSexe());
		}*/
		
		//CPatient cPatient2 = new CPatient();
		//cPatient2 = cPatient.chercher(63);
		//System.out.println("Nom :" + cPatient2.getNom() + " Prenom : " + cPatient2.getPrenom() + " Nrn : " + cPatient2.getNrn() +  " ID : " + cPatient2.getID_Patient() + " Genre : "+ cPatient2.getSexe());
		/*
		CPatient cPatient2 = new CPatient();
		LocalDate date = LocalDate.of(1994, 04, 03);
		cPatient2.setNom("Meurdesoif");
		cPatient2.setPrenom("Jean");
		cPatient2.setDateNaissance(date);
		cPatient2.setAdresse("Gosselies");
		cPatient2.setNrn(94040301285L);
		cPatient2.setSexe(Genre.Homme);
		cPatient2.setTelephone("067566321");
		
		System.out.println("Est ajout� : " + cPatient.ajouter(cPatient2));*/
		
		CMedicament m = new CMedicament();
		CMedicament cMedicament = new CMedicament();
		m = cMedicament.chercher(21);
		System.out.println(m.getNom());
				

	}

}
