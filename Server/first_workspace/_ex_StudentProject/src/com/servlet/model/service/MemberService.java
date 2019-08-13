package com.servlet.model.service;
import static common.template.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.servlet.model.dao.MemberDao;
import com.servlet.model.vo.Member;
import static common.template.JDBCTemplate.close;        

public class MemberService {
  private MemberDao dao = new MemberDao();

  public Member selectId(String id, String pwd) {
    Connection conn = getConnection();
    Member m = dao.selectId(conn,id,pwd);
    close(conn);
    return m;
  }

}
