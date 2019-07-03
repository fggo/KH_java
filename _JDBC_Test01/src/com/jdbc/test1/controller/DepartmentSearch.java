package com.jdbc.test1.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentSearch {
	public static void main(String[] args) {
		Connection conn = null; //close
		Statement stmt = null; //close
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe", "kh","kh");
			stmt = conn.createStatement();
			String query = "SELECT * FROM DEPARTMENT";

			rs = stmt.executeQuery(query);

			while(rs.next()) {
				System.out.print(rs.getString("DEPT_ID") + "\t");
				System.out.print(rs.getString("DEPT_TITLE") + "\t");
				System.out.println(rs.getString("LOCATION_ID"));
			}
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
