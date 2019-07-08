package com.jdbc.model.dao;

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

import static com.jdbc.common.JDBCTemplate.close;
import com.jdbc.model.vo.Member;

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
			
			list = this.getMemberList(rs);

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}
	
	
	public List<Member> selectId(Connection conn, String id){
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("selectId");

		ResultSet rs = null;
		
		List<Member> list = new ArrayList<Member> ();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + id + "%");
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
		
		String sql = prop.getProperty("selectName");
		
		List<Member> list = new ArrayList<Member>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			
			rs = pstmt.executeQuery();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

	private List<Member> getMemberList(ResultSet rs) {
		List<Member> list = new ArrayList<Member>();
		Member member = null;

		try {
			while(rs.next()) {
				member = new Member();

				member.setMemberId(rs.getString("member_id"));
				member.setMemberPwd(rs.getString("member_pwd"));
				member.setMemberName(rs.getString("member_name"));
				member.setEmail(rs.getString("email"));
				member.setAddress(rs.getString("address"));
				member.setPhone(rs.getString("phone"));
				member.setEnrollDate(rs.getDate("enrollDate"));

				list.add(member);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
