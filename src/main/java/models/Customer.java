package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectionFactory;

public class Customer
{
	
	public static boolean checkExistence(int id) throws SQLException
	{
		String sql = "SELECT EXISTS(SELECT * FROM customers WHERE address_id = " + id + ");";
		ResultSet existRS = ConnectionFactory.returnQueryResults(sql);
		
		boolean exists = false;
		
        while(existRS.next())
        {
        	exists = existRS.getBoolean(1);
        }
		
        return exists;

	}
	
	public static void create(String firstName, String lastName, String email) throws SQLException
	{
		String sql = "INSERT INTO customers (customer_id, name, address_id) VALUES \r\n"
				+ "('"
				+ firstName
				+ "', '"
				+ lastName 
				+ "', '"
				+ email
				+ "');";
		
		ResultSet createRS = ConnectionFactory.returnQueryResults(sql);
		System.out.println(createRS.getInt(1));
	}
	
	public static void get() throws SQLException
	{
		String sql = "SELECT * FROM customers;";
		ResultSet getRS = ConnectionFactory.returnQueryResults(sql);
		
        while(getRS.next())
        {
        	System.out.println("[Cusomer ID] | [Name] | [Address ID]");
        	System.out.println(getRS.getString("customer_id") + " | " + getRS.getString("name") + " | " + getRS.getString("address_id"));
        }
	}

	public static String get(int id) throws SQLException
	{
		if(checkExistence(id))
		{
			String sql = "SELECT * FROM customers WHERE address_id = " + id + ";";
			ResultSet getRS = ConnectionFactory.returnQueryResults(sql);
		
			while(getRS.next())
			{
				System.out.println(getRS.getString("customer_ID") + " | " + getRS.getString("name") + " | " + getRS.getString("address_ID"));
			}
			
			return "200";
		}
		else
		{
			return "404";
		}
	}
	
	public static String update(int id, String key, String value) throws SQLException
	{
	
		if(checkExistence(id))
		{
			String sql = "UPDATE customers SET " + key + " = '" + value + "' " + "WHERE address_id = " + id +";";
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
			String sql = "DELETE FROM customers WHERE address_id = " + id + ";";
			ResultSet deleteRS = ConnectionFactory.returnQueryResults(sql);
			return "200";
		}
		
		else
		{
			return "404";
		}
	}
	
}
