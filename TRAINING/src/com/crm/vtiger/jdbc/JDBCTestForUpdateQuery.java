package com.crm.vtiger.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;


import com.mysql.jdbc.Driver;

public class JDBCTestForUpdateQuery {

	Connection con;
	@Test
	public void Update_Query() throws SQLException
	{
		try
		{
			//Step 1: Register the driver/DB
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
		
			//Step 2: Connect to DB
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "admin");
	
			//Step 3: Create statement
			Statement stat = con.createStatement();
			String query = "insert into students_info (regno, firstname, middlename, lastname) values('4', 'driti','rohan', 'rishi');";
		
			//Step 4: Execute Query
			int result = stat.executeUpdate(query);
		
			//Step 5: 
			if(result==1)
			{
				System.out.println("Data is inserted");
			}
		}
		catch(Exception e)
		{
			System.out.println("Data is not inserted");
		}
		finally
		{
			con.close();
		}
	}
}
