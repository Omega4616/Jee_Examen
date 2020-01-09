package be.BiscontiLagneau.JavaBean;

import java.io.Serializable;
import java.util.List;

import be.BiscontiLagneau.DAO.DAOConnexion;
import be.BiscontiLagneau.DAO.DAOPatient;

public class CPatient extends CPersonne implements Serializable{
	
	private static final long serialVersionUID = 1L;
	//Attributs
	int ID_Patient;
	long nrn; //N° de registre national
	
	//Constructeurs
	public CPatient() {}
	
	//Méthodes
	public boolean ajouter (CPatient patient) {
		DAOPatient daoPatient = new DAOPatient();
		return daoPatient.ajouter(patient);
	}
	
	//Accesseurs
	public int getID_Patient() {
		return ID_Patient;
	}

	public void setID_Patient(int iD_Patient) {
		ID_Patient = iD_Patient;
	}
	
	public long getNrn()
	{
		return nrn;
	}
	
	public void setNrn(long nrn)
	{
		this.nrn = nrn;
	}

	public List<CPatient> recupererTousMedicaments() {
		// TODO Auto-generated method stub
		return null;
	}
}
