import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import io.javalin.Javalin;
import utils.ConnectionFactory;
import models.Customer;
import repositories.CustomerRepository;


public class EntryPoint 
{
	
    public static void main(String[] args) 
    {

        try 
        {
            //System.out.println(CustomerRepository.checkExistence(1));
            //System.out.println(CustomerRepository.checkMax("customer_id"));
            System.out.println(CustomerRepository.get());
            Customer grab = CustomerRepository.get(2);
            System.out.println(CustomerRepository.create("Cursed Deadman"));
            System.out.println(CustomerRepository.update(3, "name", "Edward Elric"));
            System.out.println(CustomerRepository.delete(6));
        } 
        
        catch (SQLException e) 
        {
            e.printStackTrace();
        }


    }
}






