package repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.sql.RowSet;

import models.Customer;
import utils.ConnectionFactory;

public class CustomerRepository
{
	
	private static Map<Integer,Customer> customers = new HashMap<>();
	
	public static boolean checkExistence(int id) throws SQLException // Checks to see if a row exists. Maybe need to move this to service layer.
	{
		String sql = "SELECT EXISTS(SELECT * FROM customers WHERE customer_id = " + id + ");";
		ResultSet existRS = ConnectionFactory.returnQueryResults(sql);
		
		boolean exists = false;
		
        while(existRS.next())
        {
        	exists = existRS.getBoolean(1);
        }
		
        return exists;

	}
	
	public static int checkMax(String key) throws SQLException //Checks for the max value of a column. Maybe need to move this to service layer.
	{
		String sql = "SELECT MAX("+ key +") FROM customers";
		ResultSet maxRS = ConnectionFactory.returnQueryResults(sql);
		
		int max = -2147483648; //Ridiculous default value so it's clear something went wrong if it goes wrong.
		
		while(maxRS.next())
		{
		max = maxRS.getInt(1);
		}
		
		return max;
	}
	
	
	public static String create(String name) throws SQLException
	{
		int next_customer_id = checkMax("customer_id") + 1;
		int next_address_id = checkMax("address_id") + 1;
		String sql = "INSERT INTO customers (customer_id, name, address_id) VALUES \r\n"
				+ "	("+next_customer_id+", '"+name+"', "+next_address_id+")";
		ResultSet createRS = ConnectionFactory.returnQueryResults(sql);
		
		int rows = -1;
		
		while(createRS.next())
		{
			rows = createRS.getInt(1);
		}
		
		return "201";
	}
	
	public static String get() throws SQLException
	{
		String sql = "SELECT * FROM customers;";
		ResultSet getRS = ConnectionFactory.returnQueryResults(sql);
		
        while(getRS.next())
        {
        	//System.out.println("[Customer ID] | [Name] | [Address ID]");
        	//System.out.println(getRS.getString("customer_id") + " | " + getRS.getString("name") + " | " + getRS.getString("address_id"));
        	Customer temp =  new Customer(getRS.getInt("customer_id"), getRS.getString("name"), getRS.getInt("address_id"));
        	customers.put(getRS.getInt("customer_id"), temp);
        	System.out.println(customers.get(getRS.getInt("customer_id")).getName());
        }
        
        return "200";
	}

	public static Customer get(int id) throws SQLException
	{
		if(checkExistence(id))
		{
			String sql = "SELECT * FROM customers WHERE customer_id = " + id + ";";
			ResultSet getRS = ConnectionFactory.returnQueryResults(sql);
			Customer temp = new Customer();
			
			while(getRS.next())
			{
				temp.setCustomer_id(getRS.getInt("customer_id"));
				temp.setName(getRS.getString("name"));
				temp.setAddress_id(getRS.getInt("address_id"));
			}
			
			return temp;
		}
		else
		{
			return null;
		}
	}
	
	public static String update(int id, String key, String value) throws SQLException
	{
	
		if(checkExistence(id))
		{
			String sql = "UPDATE customers SET " + key + " = '" + value + "' " + "WHERE customer_id = " + id +";";
			ResultSet updateRS = ConnectionFactory.returnQueryResults(sql);
			return "200";
		}
		
		else
		{
			return "404";
		}
	}
	
	public static String delete(int id) throws SQLException
	{
		if(checkExistence(id))
		{
			String sql = "DELETE FROM customers WHERE customer_id = " + id + ";";
			ResultSet deleteRS = ConnectionFactory.returnQueryResults(sql);
			return "200";
		}
		
		else
		{
			return "404";
		}
	}
	
}

