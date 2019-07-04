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
		//2.Connection 가져오기
		Connection conn = MemberDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		List<Member> list = null;
		try {
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
				member.setHobby(rs.getString("hobby"));
				member.setEnrollDate(rs.getDate("enroll_date"));

				list.add(member);
			}
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
	
	//TODO: 차후에 return이 List<Member>로 바꿀예정
	//	DB에 접속해서 전달받은 이름의 회원이 있는지 찾는 기능
	public List<Member> selectName(String memberName) {
		//DB에 접속해서 DB에 Member table 전체 데이터를 가져오는 기능
		//JDBC 이용!
		Connection conn = MemberDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		Member m = null;
		List<Member> list = new ArrayList<Member>();
		
		try {
			stmt = conn.createStatement();
			String query = "SELECT * from MEMBER WHERE member_name LIKE'%" + memberName+"%'";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				//받은결과 값 VO 객체에 저장하기
				m = new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender").charAt(0));
				m.setAge(rs.getInt("age"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("hobby"));
				m.setEnrollDate(rs.getDate("enroll_date"));

				list.add(m);
			}
				
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
	
	public List<Member> selectId(String id) {
		Connection conn = MemberDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		Member m = null;
		List<Member> list = new ArrayList<Member>();

		try {
			String query = "select * from member where member_id LIKE '%" + id +"%'";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				m = new Member();
				m.setMemberId(rs.getString("member_id"));
				m.setMemberPwd(rs.getString("member_pwd"));
				m.setMemberName(rs.getString("member_name"));
				m.setGender(rs.getString("gender").charAt(0));
				m.setAge(rs.getInt("age"));
				m.setEmail(rs.getString("email"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				m.setHobby(rs.getString("hobby"));
				m.setEnrollDate(rs.getDate("enroll_date"));

				list.add(m);
			}
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
	
	/**
	 * Insert value into Database
	 * MemberDao 에서 insert member 실행
	 */
	public int insertMember(Member m) {
		Connection conn = MemberDao.getConnection();
		Statement stmt = null;

		int result = 0;
		String sql = "INSERT INTO MEMBER VALUES("
				+ "'"+m.getMemberId() + "',"
				+ "'"+m.getMemberPwd() + "',"
				+ "'"+m.getMemberName() + "',"
				+ "'"+m.getGender() + "',"
				+ m.getAge() + ","
				+ "'"+m.getEmail() + "',"
				+ "'"+m.getPhone() + "',"
				+ "'"+m.getAddress() + "',"
				+ "'"+m.getHobby() + "',"
				+ "SYSDATE)";

		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);

			if(result>0)
				conn.commit();
			else
				conn.rollback();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	//name, age, address, hobby 
	public int updateMember(Member m) {
		Connection conn = MemberDao.getConnection();
		Statement stmt = null;
		int result = 0;
		try {
			String sql = "UPDATE MEMBER SET "
							+ "member_name='"+m.getMemberName()+"',"
							+ "age="+m.getAge()+","
							+ "address='"+m.getAddress()+"',"
							+ "hobby='"+m.getHobby() +"'"
						+ "WHERE member_id='" + m.getMemberId()+"' ";
//						+ "AND member_pwd='" + member_pwd + "'";
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);

			if (result > 0)
				conn.commit();
			else
				conn.rollback();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteMember(String id) {
		Connection conn = MemberDao.getConnection();
		Statement stmt = null;
		
		int result = 0;
		
		try {
			String sql = "DELETE FROM MEMBER WHERE member_id='" + id + "'";
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);

			if(result > 0)
				conn.commit();
			else
				conn.rollback();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	private static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
			conn.setAutoCommit(false);
			conn.commit();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}