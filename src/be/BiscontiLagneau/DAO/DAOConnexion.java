package be.BiscontiLagneau.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOConnexion {
	private static Connection instance = null;

    private DAOConnexion()
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        try
        {
            String username = "flavian";
            String pwd = "barbeapapa";
            String stringConnexion = "jdbc:oracle:thin:@//char-oracle11.condorcet.be:1521/xe";
            instance = DriverManager.getConnection(stringConnexion,username,pwd);
        }
        catch(SQLException e)
        {
        	e.printStackTrace();
        }
    }
    public static Connection getInstance()
    {
        if(instance == null) new DAOConnexion();
        return instance;
    }
}
