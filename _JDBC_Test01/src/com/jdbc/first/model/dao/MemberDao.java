package com.jdbc.first.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.first.model.vo.Member;

//DB 데이터 가져옴
public class MemberDao {
	//전체회원조회 메소드
	public List<Member> selectAll(){
		//DB에 접속해서 DB에 Member table 전체 데이터를 가져오는 기능
		//JDBC 이용!
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Member> list = null;
		try {
			//1. 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.Connection 가져오기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "student","student");
			//3.Statement 객체 생성
			stmt = conn.createStatement();
			String query = "SELECT * from MEMBER";
			//4.쿼리문 실행하고 결과값 받기
			rs = stmt.executeQuery(query);
			//5.받은결과 값 VO 객체에 저장하기

			list = new ArrayList<Member>();

			Member member = null;
			while(rs.next()) {
				member = new Member();

				member.setMemberId(rs.getString("member_id"));
				member.setMemberPwd(rs.getString("member_pwd"));
				member.setMemberName(rs.getString("member_name"));
				member.setGender(rs.getString("gender").charAt(0));
				member.setAge(rs.getInt("age"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
				member.setHobbby(rs.getString("hobby"));
				member.setEnrollDate(rs.getDate("enroll_date"));

				list.add(member);
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

		return list;
	}
}