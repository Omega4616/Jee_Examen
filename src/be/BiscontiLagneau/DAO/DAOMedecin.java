package be.BiscontiLagneau.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import be.BiscontiLagneau.Enum.Specialisation;
import be.BiscontiLagneau.POJO.CMedecin;
import be.BiscontiLagneau.POJO.CPatient;

public abstract class DAOMedecin extends DAO<CMedecin>{
	public DAOMedecin(Connection connec)
	{
		super(connec);
	}
	
	public CMedecin getMedecin(int inami, String mdp)
	{
		CMedecin medecin = null;
        try
        {
            ResultSet result = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY	).executeQuery("SELECT * FROM Medecins M "
                    		+ "INNER JOIN Personnes P ON P.id_personne = M.id_personne "
                    		+ "WHERE num_inami = " + inami + " AND mdp = '" + mdp + "'");

            while(result.next())
            {
            	medecin = new CMedecin();
                medecin.setNom(result.getString("nom"));
                medecin.setPrenom(result.getString("prenom"));
                medecin.setAdresse(result.getString("adresse"));
                //medecin.setDateNaissance(result.getDate("naissance"));
                //medecin.setDateDiplome(result.getDate("date_diplome "));
                medecin.setInami(result.getInt("inami"));
                medecin.setAdresseCabinet(result.getString("adresse_cabinet"));
                medecin.setTelephone(result.getString("telephone"));
                //sexe
                
                switch(result.getString("specialisation "))
                {
                	case "Cardiologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Cardiologie);
                		break;
                	}
                	case "Dermatologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Dermatologie);
                		break;
                	}
                	case "Generale" :
                	{
                		medecin.setSpecialisation(Specialisation.Generale);
                		break;
                	}
                	case "Gynecologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Gynecologie);
                		break;
                	}
                	case "Neurologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Neurologie);
                		break;
                	}
                	case "Ophtalmologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Ophtalmologie);
                		break;
                	}
                	case "Psychiatre" :
                	{
                		medecin.setSpecialisation(Specialisation.Psychiatre);
                		break;
                	}
                	case "Pneumologie" :
                	{
                		medecin.setSpecialisation(Specialisation.Pneumologie);
                		break;
                	}
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return medecin;
	}
}
