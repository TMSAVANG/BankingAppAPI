import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.javalin.Javalin;
import utils.ConnectionFactory;
import models.Customer;


public class EntryPoint 
{
	
    public static void main(String[] args) 
    {

        try 
        {
            //Customer.create("Argos", "Bouchard", "arugos.bouchard@argosbouchard.pizza");// Creating new client.
            Customer.get(); //Getting all clients (overloaded method 1)
            Customer.get(7); //Getting a specific client(overloaded method 2)
            //Customer.get(8);
            //System.out.println(Client.checkExistence(1)); //Checking if a client exists.
            //Customer.update(1, "email", "argos.bouchard@abpizza.pizza"); //Updating with key value
            //Customer.get(7);
            //Customer.delete(1);
            //Customer.get(1);
            Javalin app = Javalin.create().start(7001);
            
        } 
        
        catch (SQLException e) 
        {
            e.printStackTrace();
        }


    }
}






