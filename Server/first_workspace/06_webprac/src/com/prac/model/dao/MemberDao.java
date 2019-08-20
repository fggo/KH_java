package com.prac.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.prac.model.vo.Member;

import static common.template.JDBCTemplate.close;

public class MemberDao {

  private Properties prop = new Properties();

  public MemberDao() {
    String path = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
    try {
      prop.load(new FileReader(path));
    } catch(IOException e) {
      e.printStackTrace();
    }
  }

  public Member selectId(Connection conn, String id, String pw) {
    Member m = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = prop.getProperty("selectId");

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pw);
      rs = pstmt.executeQuery();
      if(rs.next()) {
        m = new Member();

        m.setUserId(rs.getString("userId"));
        m.setPassword(rs.getString("password"));
        m.setUserName(rs.getString("userName"));
        m.setGender(rs.getString("gender").charAt(0));
        m.setAge(rs.getInt("age"));
        m.setEmail(rs.getString("email"));
        m.setPhone(rs.getString("phone"));
        m.setAddress(rs.getString("address"));
        m.setHobby(rs.getString("hobby"));
        m.setEnrolldate(rs.getDate("enrollDate"));
      }
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
      pstmt.setString(1, m.getUserId());
      pstmt.setString(2, m.getPassword());
      pstmt.setString(3, m.getUserName());
      pstmt.setString(4, String.valueOf(m.getGender()));
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

}
