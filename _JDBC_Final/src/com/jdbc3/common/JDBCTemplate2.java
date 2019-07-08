package com.jdbc3.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate2 {
	private static Properties prop = new Properties();

	//1. Connection을 생성함.
	//2. Connection으로 생성한 객체 (PreparedStatment, ResultSet, rollback, commit등의 객체)
	//	 를 반환해주는 기능 (메소드)
	//3. 공용객체로 static을 사용하여 선언을 함

	//Service에서 conneciton 메소드 활용
	//dao에서는 객체를 닫기 위해 활용
	public static Connection getConnection() {
		Connection conn = null;
		// load from .properties
		try {
			prop.load(new FileReader("resources/driver.properties"));
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"),
						prop.getProperty("user"), prop.getProperty("pw"));
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	//사용한객체 반납메소드 관리
	//Connection, Statement, ResultSet, 트랜젝션 Transaction
	public static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//statement -> preparedStatement(따로 안만들어도 됨)
	//polymorphism에 의 해 같이 close 객체반환에 대해 Statement만 만들면 된다.
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
	