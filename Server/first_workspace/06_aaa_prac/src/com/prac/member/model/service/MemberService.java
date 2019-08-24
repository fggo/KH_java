package com.prac.member.model.service;

import static common.template.JDBCTemplate.close;
import static common.template.JDBCTemplate.commit;
import static common.template.JDBCTemplate.getConnection;
import static common.template.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.prac.member.model.dao.MemberDao;
import com.prac.member.model.vo.Member;

public class MemberService {
  private MemberDao dao = new MemberDao();

  public Member selectId(String id, String pw) {
    Connection conn = getConnection();
    Member m = dao.selectId(conn, id,pw);
    close(conn);
    return m;
  }
//  public Member selectMember(String userId) {
//    Connection conn = getConnection();
//    Member m = dao.selectMember(conn, userId);
//
//    close(conn);
//
//    return m;
//  }
//  
//  public boolean selectCheckId(String id) {
//    Connection conn = getConnection();
//    boolean result = dao.selectCheckId(conn, id);
//    
//    close(conn);
//
//    return result;
//  }
//  
//  public int insertMember(Member m) {
//    Connection conn = getConnection();
//    int result = dao.insertMember(conn, m);
//    //트랜젝션 처리
//    if(result > 0)
//      commit(conn);
//    else
//      rollback(conn);
//
//    close(conn);
//    return result;
//  }
//  
//  public int updateMember(Member m) {
//    Connection conn = getConnection();
//    int result = dao.updateMember(conn, m);
//
//    if(result >0)
//      commit(conn);
//    else
//      rollback(conn);
//
//    close(conn);
//
//    return result;
//  }
//  
//  public int deleteMember(String id) {
//    Connection conn = getConnection();
//    int result = dao.deleteMember(conn, id);
//    
//    if(result >0)
//      commit(conn);
//    else
//      rollback(conn);
//    
//    close(conn);
//    
//    return result;
//  }
//  
//  public int updatePassword(String userId, String password, String passwordNew) {
//    Connection conn = getConnection();
//
//    //1.일단 비밀번호가 맞는지 확인
//    Member m = dao.selectId(conn, userId, password);
//    int result = 0;
//    if(m != null) {
//      //password 수정
//      result = dao.updatePassword(conn,userId,passwordNew);
//    }
//    else {
//      //password 수정 X
//      result = -1; //현재 패스워드가 틀렸다는 것
//      //result ==0일때는 시스템 적인 문제로 데이터가안들어갔을 때
//    }
//    if(result >0)
//      commit(conn);
//    else
//      rollback(conn);
//    
//    close(conn);
//    
//    //result=0 업데이트 실패(로직 문제 또는 시스템 문제로 수정이 안됏을때)
//    //result=1 업데이트 성공
//    //result=-1 현재 패스워드 검증 실패
//    //구분자로 분기해서 에러 메시지 정의 가능
//
//    return result;
//  }
//  
//  public List<Member> selectList() {
//    Connection conn = getConnection();
//    List<Member> list = dao.selectList(conn);
//    
//    close(conn);
//
//    return list;
//  }
}