package com.crm.vtiger.jdbc;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class JDBCTestForExeQuery {

	@Test
	public void Execute_Query() throws Throwable 
	{
		//Step 1: Registering the driver/DB
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Step 2: Connect to the DB
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "admin");
		
		//Step 3: issue/create sql statement
		Statement stat = con.createStatement();
		String query = "select * from students_info";
		
		//Step 4: execute sql query
		ResultSet result = stat.executeQuery(query);
		
		
		//process the result
		while(result.next())
		{
			System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t");
		}
		
		//Step 5: Close the connection
		con.close();
	}
}
