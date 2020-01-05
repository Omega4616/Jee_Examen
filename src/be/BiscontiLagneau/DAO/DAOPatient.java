package be.BiscontiLagneau.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import be.BiscontiLagneau.javaBean.CPatient;

public class DAOPatient extends DAO<CPatient>{

	@Override
	public boolean ajouter(CPatient obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean supprimer(CPatient obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifier(CPatient obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CPatient chercher(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CPatient> recupererTout() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	public CPatient getPatient(int nss)
	{
		CPatient patient = null;
        try
        {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY	).executeQuery("SELECT * FROM Patients PA "
                    		+ "INNER JOIN Personnes PE ON PA.id_personne = PE.id_personne "
                    		+ "WHERE nss = " + nss);

            while(result.next())
            {
                patient = new CPatient();
                patient.setNom(result.getString("nom"));
                patient.setPrenom(result.getString("prenom"));
                patient.setAdresse(result.getString("adresse"));
                //patient.setDateNaissance(result.getDate("naissance"));
                patient.setNss(result.getInt("nss"));
                patient.setTelephone(result.getString("telephone"));
                //sexe
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return patient;
	}*/
}
