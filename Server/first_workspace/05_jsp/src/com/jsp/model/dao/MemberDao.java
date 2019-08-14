package com.jsp.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static common.template.JDBCTemplate.close;

import com.jsp.model.vo.Member;

public class MemberDao {
  public Member selectId(Connection conn, String id, String pw) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Member m = null;
    String sql = "select * from member where member_id=? and member_pwd=?";

    try {
      pstmt =conn.prepareStatement(sql);
      pstmt.setString(1, id);
      pstmt.setString(2, pw);
      rs = pstmt.executeQuery();
      if(rs.next()) {
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
      close(rs);
      close(pstmt);
    }
    return m;
    
  }
}
