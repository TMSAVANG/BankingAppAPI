package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.ConnectionFactory;

public class Client 
{
	
	public static boolean checkExistence(int id) throws SQLException
	{
		String sql = "SELECT EXISTS(SELECT * FROM users WHERE id = " + id + ");";
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
		String sql = "INSERT INTO users (first_name, last_name, email) VALUES \r\n"
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
		String sql = "SELECT * FROM users;";
		ResultSet getRS = ConnectionFactory.returnQueryResults(sql);
		
        while(getRS.next())
        {
        	System.out.println("[First Name] | [Last Name] | [Email]");
        	System.out.println(getRS.getString("first_name") + " | " + getRS.getString("last_name") + " | " + getRS.getString("email"));
        }
	}

	public static void get(int id) throws SQLException
	{
		if(checkExistence(id))
		{
			String sql = "SELECT * FROM users WHERE id = " + id + ";";
			ResultSet getRS = ConnectionFactory.returnQueryResults(sql);
		
			while(getRS.next())
			{
				System.out.println(getRS.getString("first_name") + " | " + getRS.getString("last_name") + " | " + getRS.getString("email"));
			}
		}
		else
		{
			System.out.println("404"); //Needs to be handled a different way when the javalin side comes in probably.
		}
	}
	
	public static void update(int id, String key, String value) throws SQLException
	{
	
		if(checkExistence(id))
		{
			String sql = "UPDATE users SET " + key + " = '" + value + "' " + "WHERE id = " + id +";";
			ResultSet updateRS = ConnectionFactory.returnQueryResults(sql);
		}
		
		else
		{
			System.out.println("404");
		}
	}
	
	public static void delete(int id) throws SQLException
	{
		if(checkExistence(id))
		{
			String sql = "DELETE FROM users WHERE ID = " + id + ";";
			ResultSet deleteRS = ConnectionFactory.returnQueryResults(sql);
		}
		
		else
		{
			System.out.println("404");
		}
	}
	
}
