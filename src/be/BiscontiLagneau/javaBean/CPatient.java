package be.BiscontiLagneau.JavaBean;

import java.io.Serializable;

public class CPatient extends CPersonne implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//Attributs
	int nss; //N� s�curit� sociale
	
	//Constructeurs
	public CPatient() {}
	
	//Accesseurs
	public int getNss()
	{
		return nss;
	}
	
	public void setNss(int nss)
	{
		this.nss = nss;
	}
}
