package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {
	public static void main(String[] args) {
		//1. Register the Driver class
		//2. Create Connection Object
		//		jdbc is the API
		//		oracle is the database
		//		thin is the driver
		//		localhost is the server name on which oracle is running,
		//		we may also use IP address,
		//		1521 is the port number
		//		XE is the Oracle service name
		//3. Create the Statement Object
		//4. Execute Queries
		//5. Close the Connection Object
		//con.close(); 
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kh","kh");  
			Statement stmt = con.createStatement();  
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");) {

			Class.forName("oracle.jdbc.driver.OracleDriver");  

			while(rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(2));  

		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}
}
