package com.jdbc3.model.dao;

import static com.jdbc3.common.JDBCTemplate2.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.jdbc3.model.vo.Member;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		try {
			prop.load(new FileReader("resources/member_query.properties"));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public List<Member> selectAll(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectAll");

		List<Member> list = new ArrayList<Member>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			list = getMemberList(rs);

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	public List<Member> selectName(Connection conn, String name){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Member> list = new ArrayList<Member>();
		Member m = null;

		try {
			String sql = prop.getProperty("selectName");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			
			rs = pstmt.executeQuery();
		
			list = this.getMemberList(rs);

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	public Member selectId(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectId");

		Member m = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();

			m = getMember(rs);

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return m;
	}
	
	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMember");

		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getMemberId());
			pstmt.setString(2, m.getMemberPwd());
			pstmt.setString(3, m.getMemberName());
			pstmt.setString(4, "" + m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			result = pstmt.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMember");
		
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getAge());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getMemberId());
			
			result = pstmt.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int deleteMember(Connection conn, String id) {
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("deleteMember");

		int result  = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	private Member getMember(ResultSet rs) {

		Member member = null;
		try {
			if(rs.next()) {
				member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberPwd(rs.getString("member_pwd"));
				member.setMemberName(rs.getString("member_name"));
				member.setAge(rs.getInt("age"));
				member.setGender(rs.getString("gender").charAt(0));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setHobby(rs.getString("hobby"));
				member.setEnrollDate(rs.getDate("enroll_date"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}
	
	private List<Member> getMemberList(ResultSet rs) {
		List<Member> list = new ArrayList<Member>();
		Member member = null;

		try {
			if(rs.next()) {
				member = new Member();

				member.setMemberId(rs.getString("member_id"));
				member.setMemberPwd(rs.getString("member_pwd"));
				member.setMemberName(rs.getString("member_name"));
				member.setAge(rs.getInt("age"));
				member.setGender(rs.getString("gender").charAt(0));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setHobby(rs.getString("hobby"));
				member.setEnrollDate(rs.getDate("enroll_date"));
				
				list.add(member);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
