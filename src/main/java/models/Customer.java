package models;

import java.util.Objects;

public class Customer
{
	
	public Customer()
	{
		super();
	}
	
	public Customer(int customer_id, String name, int address_id) 
	{
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.address_id = address_id;
	}

	
	//customer_id
	private int customer_id;

	public int getCustomer_id() 
	{
		return customer_id;
	}

	public void setCustomer_id(int customer_id) 
	{
		this.customer_id = customer_id;
	}

	@Override
	public int hashCode() 
	{
		return Objects.hash(customer_id);
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return customer_id == other.customer_id;
	}

	@Override
	public String toString() 
	{
		return "Customer [customer_id=" + customer_id + "]";
	}
	//end of customer_id
	
	
	private String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
	
	
	
	
	private int address_id;

	public int getAddress_id() 
	{
		return address_id;
	}

	public void setAddress_id(int address_id) 
	{
		this.address_id = address_id;
	}


	
	
}