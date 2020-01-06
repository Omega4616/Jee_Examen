package be.Lagneau.test;

import be.BiscontiLagneau.JavaBean.*;
import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CMedecin m = new CMedecin();
		m = m.authentification(14689278354L, "test");
		
		System.out.println(m.toString());
		
		CMedicament cMedicament = new CMedicament();
		List<CMedicament> cMedicaments = cMedicament.recupererTousMedicaments();
		
		for (CMedicament medoc : cMedicaments) {
			System.out.println("Nom médoc :" + medoc.getNom() + "Type : " + medoc.getType() + "Dosage : " + medoc.getDosage_jour_max() +  "Description : " + medoc.getDescription() + "ID : "+ medoc.getID_Medicament());
		}

	}

}
