package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {
	public static void main(String[] args) {
		Connection conn = null; //close
		Statement stmt = null; //close
		ResultSet rs = null;
		try {
//			DB connection Test
//			1. Register Driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Register Complete!");
//			2. Create Connection Object, Using DriverManager.getConnection()
//			 type getConnection() parameters
//			 parameters:
//			   DMBS address(url), pattern, id, pw
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
						"student", "student");
			System.out.println("DBMS connection Complete!");

//			3. Create Statement Object using Connection info
//			   Statement object to execute sql in DBMS and get resultset;
			stmt = conn.createStatement();

//			4. statement객체에 DMBS에서 실행할 sql구문을 보냄.
//			조회구문(select) : executeQuery(statement);
//						-> ResultSet 데이터테이블 전송
//			DML(입력, 수정, 삭제) : executeUpdate(statement);
//						-> int,입력,수정,삭제된 데이터의 갯수 반환
			String query = "SELECT * FROM MEMBER";
			rs = stmt.executeQuery(query);
			System.out.println("Query statement executed! " + rs);
			
//			5. print ResultSet. Assign to VO OBJECT. 결과값 객체에 대입해주기 (VO)
			//ResultSet에 담겨있는 테이블의 첫번째 행이 선택, 
			// row가 있으면 true, 없으면 false 반환
			//ResultSet객체에서 값을 가져오는 메소드
			//	1. getString()->VARCHAR2로 되어있는 자료를 가졍ㄹ때
			//	2. getInt() -> NUMBER로 되어있는 자료를 가져올때
			//	3. getDate() -> DATE로 되어 있는 자료를 가져올때
			//각 get자료형() 매개변수 ->String 으로 DB table의 컬럼명 / int 인덱스값(1,2,3,...)
			while(rs.next()) {
				System.out.print(rs.getString("member_id"));
				System.out.print(rs.getString("member_pwd"));
				System.out.print(rs.getString("member_name"));
				System.out.print(rs.getString(4));
				System.out.println(rs.getInt(5));
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
