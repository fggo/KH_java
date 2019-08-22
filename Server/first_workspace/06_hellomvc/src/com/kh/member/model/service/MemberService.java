package com.kh.member.model.service;

import static common.template.JDBCTemplate.close;
import static common.template.JDBCTemplate.commit;
import static common.template.JDBCTemplate.getConnection;
import static common.template.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {
  private MemberDao dao = new MemberDao();

  public Member selectId(String id, String pw) {
    Connection conn = getConnection();
    Member m = dao.selectId(conn, id,pw);
    close(conn);
    return m;
  }
  public Member selectMember(String userId) {
    Connection conn = getConnection();
    Member m = dao.selectMember(conn, userId);

    close(conn);

    return m;
  }
  
  public boolean selectCheckId(String id) {
    Connection conn = getConnection();
    boolean result = dao.selectCheckId(conn, id);
    
    close(conn);

    return result;
  }
  
  public int insertMember(Member m) {
    Connection conn = getConnection();
    int result = dao.insertMember(conn, m);
    //트랜젝션 처리
    if(result > 0)
      commit(conn);
    else
      rollback(conn);

    close(conn);
    return result;
  }
  
  public int updateMember(Member m) {
    Connection conn = getConnection();
    int result = dao.updateMember(conn, m);

    if(result >0)
      commit(conn);
    else
      rollback(conn);

    close(conn);

    return result;
  }
  
  public int deleteMember(String id) {
    Connection conn = getConnection();
    int result = dao.deleteMember(conn, id);
    
    if(result >0)
      commit(conn);
    else
      rollback(conn);
    
    close(conn);
    
    return result;
  }
  
  public int updatePassword(String id, String pwNew) {
    Connection conn = getConnection();
    int result = dao.updatePassword(conn, id, pwNew);
    
    if(result >0)
      commit(conn);
    else
      rollback(conn);
    
    close(conn);
    
    return result;
  }
}
