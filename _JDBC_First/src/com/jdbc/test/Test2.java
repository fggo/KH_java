package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test2 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement prep_stmt = null;
		try {
			//1. Register the Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");  

			//2. Create Connection Object
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kh","kh");  

			//3. Create the Statement Object
			String sql = "INSERT INTO EMPLOYEE(emp_id, emp_name, emp_no, sal_level, job_code) VALUES(?,?,?,?,?)";
			prep_stmt=conn.prepareStatement(sql);
			prep_stmt.setInt(1, 999); //1 specifies the first parameter in the query
			prep_stmt.setString(2, "댕댕이");
			prep_stmt.setString(3, "171111-3000777");
			prep_stmt.setString(4, "S1");
			prep_stmt.setString(5, "J3");

			//4. Execute Queries
			int i = prep_stmt.executeUpdate();
			System.out.println(i + " records INSERT COMPLETE!");
			

		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			//5. Close the Connection Object
			try {
				prep_stmt.close();
				conn.close(); 
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
