package com.prac.model.service;

import static common.template.JDBCTemplate.getConnection;
import static common.template.JDBCTemplate.close;
import static common.template.JDBCTemplate.commit;
import static common.template.JDBCTemplate.rollback;

import java.sql.Connection;

import com.prac.model.dao.MemberDao;
import com.prac.model.vo.Member;

public class MemberService {
  private MemberDao dao = new MemberDao();

  public Member selectId(String id, String pw) {
    Connection conn = getConnection();
    Member m = dao.selectId(conn, id, pw);
    close(conn);

    return m;
  }
  
  public int insertMember(Member m) {
    Connection conn = getConnection();

    int result = dao.insertMember(conn, m);
    
    if(result >0)
      commit(conn);
    else
      rollback(conn);

    close(conn);

    return result;
  }
}
