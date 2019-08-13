package com.servlet.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.servlet.model.vo.Member;

public class MemberDao {
  private Properties prop = new Properties();

  public MemberDao() {
    String path = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
    try {
      prop.load(new FileReader(path));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Member selectId(Connection conn, String id, String pw) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = prop.getProperty("selectId");
    Member m = null;
    try {
      pstmt= conn.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pw);
      
      rs = pstmt.executeQuery();

      if(rs.next()){
        m=new Member();
        m.setMemberId(rs.getString("member_id"));
        m.setMemberName(rs.getString("member_name"));
        m.setGender(rs.getString("gender"));
        m.setAge(rs.getInt("age"));
        m.setAddress(rs.getString("address"));
        m.setHobby(rs.getString("hobby"));
        m.setEnrollDate(rs.getDate("enroll_date"));
        m.setEmail(rs.getString("email"));
        m.setPhone(rs.getString("phone"));
      }
    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        pstmt.close();
        rs.close();
        
      } catch(Exception e) {
        e.printStackTrace();
      }
      
    }
    return m;
    
  }
}
