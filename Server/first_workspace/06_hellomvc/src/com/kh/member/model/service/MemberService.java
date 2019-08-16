package com.kh.member.model.service;

import static common.template.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

import static common.template.JDBCTemplate.close;

public class MemberService {
  private MemberDao dao = new MemberDao();

  public Member selectId(String id, String pw) {
    Connection conn = getConnection();
    Member m = dao.selectId(conn, id,pw);
    close(conn);
    return m;
  }
}
