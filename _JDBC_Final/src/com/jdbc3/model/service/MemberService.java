package com.jdbc3.model.service;

import static com.jdbc3.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import static com.jdbc3.common.JDBCTemplate.close;
import com.jdbc3.model.dao.MemberDao;
import com.jdbc3.model.vo.Member;

//1.Connection 객체를 관리하는 객체
//2. 트랜젝션을 관리하는 객체
public class MemberService {
	private MemberDao dao = new MemberDao();

	public List<Member> selectAll(){
		Connection conn = getConnection();
		List<Member> list = dao.selectAll(conn);

		close(conn);

		return list;

//		int result1 = dao.insertMember();
//		int result2 = dao.updateMember();
//		int result3 = dao.deleteMember();
//		if(result1 ==0 || result2==0 || result3==0 ) {
//			rollback();
//		}
	}
	
	public Member selectId(String id) {
		Connection conn = getConnection();
		Member m = dao.selectId(conn, id);
		
		close(conn);
		
		return m;
	}

	public List<Member> selectName(String name){
		Connection conn = getConnection();
		List<Member> list = dao.selectName(conn, name);
		
		close(conn);

		return list;
	}
}
