package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) {
		try {
			//1. Register the Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");  

			//2. Create Connection Object
			//		jdbc is the API
			//		oracle is the database
			//		thin is the driver
			//		localhost is the server name on which oracle is running,
			//		we may also use IP address,
			//		1521 is the port number
			//		XE is the Oracle service name
			Connection con = DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","kh","kh");  

			//3. Create the Statement Object
			Statement stmt = con.createStatement();  

			String sql = "INSERT INTO EMPLOYEE(emp_id, emp_name, emp_no, sal_level, job_code)"
								+ "VALUES(?,?,?,?,?)";
			PreparedStatement prep_stmt=con.prepareStatement(sql);
//			PreparedStatement prep_stmt
//				= con.prepareStatement("UPDATE EMPLOYEE SET emp_name=? where emp_id=?");  
			prep_stmt.setInt(1, 999); //1 specifies the first parameter in the query
			prep_stmt.setString(2, "�����");
			prep_stmt.setString(3, "171111-3000777");
			prep_stmt.setString(4, "S1");
			prep_stmt.setString(5, "J3");
//			INSERT INTO employee(emp_id, emp_name, emp_no, sal_level, job_code)
//		    VALUES(904, '�����', '1711111-3000777', 'S1', 'J3');


			//4. Execute Queries
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEE");  
			while(rs.next())
				System.out.println(rs.getInt(1) + " " + rs.getString(2));  
			
			int i = prep_stmt.executeUpdate();
			System.out.println(i + " records INSERTed");
			

			//5. Close the Connection Object
			con.close(); 

		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}
}
