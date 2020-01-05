package be.Lagneau.test;

import be.BiscontiLagneau.javaBean.CMedecin;
import be.BiscontiLagneau.Servlet.AuthentificationMedecin;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CMedecin m = new CMedecin();
		m = m.authentification(14689278354L, "test");
		
		System.out.println(m.toString());

	}

}
