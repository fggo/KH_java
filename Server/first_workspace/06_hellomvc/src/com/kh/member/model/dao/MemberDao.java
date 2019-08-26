package com.kh.member.model.dao;

import static common.template.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.member.model.vo.Member;

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

  public Member selectMember(Connection conn, String userId) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Member m =null;
    String sql = prop.getProperty("selectCheckId");
    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, userId);
      rs = pstmt.executeQuery();
      if(rs.next()) {
        m = new Member();
  
        m.setUserId(rs.getString("userId"));
        m.setUserName(rs.getString("userName"));
        m.setGender(rs.getString("gender").charAt(0));
        m.setAge(rs.getInt("age"));
        m.setEmail(rs.getString("email"));
        m.setPhone(rs.getString("phone"));
        m.setAddress(rs.getString("address"));
        m.setHobby(rs.getString("hobby"));
        m.setEnrollDate(rs.getDate("enrollDate"));
      }
    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs);
      close(pstmt);
    }
    return m;
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
        m.setUserName(rs.getString("userName"));
        m.setGender(rs.getString("gender").charAt(0));
        m.setAge(rs.getInt("age"));
        m.setEmail(rs.getString("email"));
        m.setPhone(rs.getString("phone"));
        m.setAddress(rs.getString("address"));
        m.setHobby(rs.getString("hobby"));
        m.setEnrollDate(rs.getDate("enrollDate"));
      }
    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs);
      close(pstmt);
    }

    return m;
  }
  
  //아이디 중복 확인
  public boolean selectCheckId(Connection conn, String userId) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    boolean result = false;
    String sql = prop.getProperty("selectCheckId");

    try {
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, userId);
      rs = pstmt.executeQuery();
      if(!rs.next()) {
        result = true;
      }
    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs);
      close(pstmt);
    }

    return result;
  }
  
  public int insertMember(Connection conn, Member m) {
    PreparedStatement pstmt = null;
    int result = 0;

    String sql = prop.getProperty("insertMember");

    System.out.println(m);
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
  
  public int updateMember(Connection conn, Member m) {
    PreparedStatement pstmt = null;
    String sql = prop.getProperty("updateMember");
    int result = 0;
    try {
      pstmt = conn.prepareStatement(sql);
//        update member set userName=?,
//            gender=?,
//            age=?,
//            email=?,
//            phone=?,
//            address=?,
//            hobby=?,
//  where userId=?
      pstmt.setString(1, m.getUserName());
      pstmt.setString(2, String.valueOf(m.getGender()));
      pstmt.setInt(3, m.getAge());
      pstmt.setString(4, m.getEmail());
      pstmt.setString(5, m.getPhone());
      pstmt.setString(6, m.getAddress());
      pstmt.setString(7, m.getHobby());
      pstmt.setString(8, m.getUserId());

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
    int result = 0;
    
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
  
  public int updatePassword(Connection conn, String userId, String passwordNew) {
    PreparedStatement pstmt = null;
    String sql = prop.getProperty("updatePassword");
    int result = 0;
    try {
      pstmt=conn.prepareStatement(sql);
      pstmt.setString(1, passwordNew);
      pstmt.setString(2, userId);
      result = pstmt.executeUpdate();
    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      close(pstmt);
    }
    return result;
  }
  
  public List<Member> selectList(Connection conn){
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<Member> list = new ArrayList<Member>();
    String sql = prop.getProperty("selectList");

    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while(rs.next()) {
        Member m = new Member();
  
        m.setUserId(rs.getString("userId"));
        m.setUserName(rs.getString("userName"));
        m.setGender(rs.getString("gender").charAt(0));
        m.setAge(rs.getInt("age"));
        m.setEmail(rs.getString("email"));
        m.setPhone(rs.getString("phone"));
        m.setAddress(rs.getString("address"));
        m.setHobby(rs.getString("hobby"));
        m.setEnrollDate(rs.getDate("enrollDate"));

        list.add(m);
      }
    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs);
      close(pstmt);
    }
    
    return list;
  }
  
  public int selectCountMember(Connection conn) {
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    int result = 0;
    String sql = prop.getProperty("selectCountMember");
    
    try {
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      if(rs.next()) {
        //result = rs.getInt(1); // 첫번쨰 컬럼 select(가독성 떨어져서 사용 자제)
        result = rs.getInt("cnt");
      }
      
    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs);
      close(pstmt);
    }
    
    return result;
  }
  
  //page에 해당하는 데이터만 가져오기
  public List<Member> selectListPage(Connection conn, int cPage, int numPerPage){
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = prop.getProperty("selectListPage");
    List<Member> list = new ArrayList<Member>();

    try {
      pstmt = conn.prepareStatement(sql);
      //(e.g) 6~10 11~15 16~20 21~25
      //ROWNUM을 기준으로
      pstmt.setInt(1, (cPage-1)*numPerPage + 1);
      pstmt.setInt(2, cPage*numPerPage);
      rs = pstmt.executeQuery();
      while(rs.next()) {
        Member m = new Member();
  
        m.setUserId(rs.getString("userId"));
        m.setUserName(rs.getString("userName"));
        m.setGender(rs.getString("gender").charAt(0));
        m.setAge(rs.getInt("age"));
        m.setEmail(rs.getString("email"));
        m.setPhone(rs.getString("phone"));
        m.setAddress(rs.getString("address"));
        m.setHobby(rs.getString("hobby"));
        m.setEnrollDate(rs.getDate("enrollDate"));

        list.add(m);
      }
    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs);
      close(pstmt);
    }
    
    return list;
  }

  public int selectCountMember(Connection conn, String type, String key) {
    Statement stmt = null;
    ResultSet rs = null;
    String sql = "select count(*) as cnt from member where "+ type+ " like '%" + key + "%'";
    int result = 0;
    
    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      if(rs.next()) {
        result = rs.getInt("cnt");
      }
    } catch(SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs);
      close(stmt);
    }
    return result;
  }

  public List<Member> selectMemberList(Connection conn, String type, String key, int cPage, int numPerPage){
    Statement stmt = null;
    ResultSet rs = null;
    List<Member> list = new ArrayList<Member>();
    int start=(cPage-1)*numPerPage+1;
    int end=cPage*numPerPage;

    String sql="select * from ("
        + "select rownum as rnum, a.* from("
        + "select * from member where "
        + type+" like '%"+key+"%' )a) "
        + "where rnum between "+start+" and "+end;
    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      
      while(rs.next()) {
        Member m = new Member();
  
        m.setUserId(rs.getString("userId"));
        m.setUserName(rs.getString("userName"));
        m.setGender(rs.getString("gender").charAt(0));
        m.setAge(rs.getInt("age"));
        m.setEmail(rs.getString("email"));
        m.setPhone(rs.getString("phone"));
        m.setAddress(rs.getString("address"));
        m.setHobby(rs.getString("hobby"));
        m.setEnrollDate(rs.getDate("enrollDate"));

        list.add(m);
      }
    }catch(SQLException e) {
      e.printStackTrace();
    } finally {
      close(rs);
      close(stmt);
    }
    return list;

  }
}
