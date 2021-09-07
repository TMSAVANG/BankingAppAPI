package utils;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class ConnectionFactory {

    private static Connection connection;

    private ConnectionFactory() {

    }

    public static Connection getConnection() {
        if(connection == null) {
            try {
            
            	Properties props = new Properties();
            	FileReader connectionProperties = new FileReader("src/main/resources/connection.properties");
            	props.load(connectionProperties);
            	
            	String connectionString = "jdbc:mariadb://"
            			+ props.getProperty("endpoint") + ":"
            			+ props.getProperty("port") + "/"
            			+ props.getProperty("dbname") + "?user="
            			+ props.getProperty("username") +"&password="
            			+ props.getProperty("password");
            
                connection = DriverManager.getConnection(connectionString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    
    public static ResultSet returnQueryResults(String sql)
    {
    	Connection conn = ConnectionFactory.getConnection();
    	
    	ResultSet rs = null;
    	
        try 
        {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        }
        
        catch(SQLException e)
        {
        	e.printStackTrace();
        }
        
        return rs;
    }

}
