import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectionFactory;
import models.Client;


public class EntryPoint 
{
	
    public static void main(String[] args) 
    {

        try 
        {
            //Client.create("Argos", "Bouchard", "arugos.bouchard@argosbouchard.pizza");// Creating new client.
            Client.get(); //Getting all clients (overloaded method 1)
            //Client.get(7); //Getting a specific client(overloaded method 2)
            //Client.get(8);
            //System.out.println(Client.checkExistence(1)); //Checking if a client exists.
            //Client.update(1, "email", "argos.bouchard@abpizza.pizza"); //Updating with key value
            //Client.get(7);
            //Client.delete(1);
            //Client.get(1);
        } 
        
        catch (SQLException e) 
        {
            e.printStackTrace();
        }


    }
}






