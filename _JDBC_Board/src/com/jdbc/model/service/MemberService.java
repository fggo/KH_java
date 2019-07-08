package com.jdbc.model.service;

import static com.jdbc.common.JDBCTemplate.getConnection;
import static com.jdbc.common.JDBCTemplate.close;
import static com.jdbc.common.JDBCTemplate.commit;
import static com.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.jdbc.model.dao.MemberDao;
import com.jdbc.model.vo.Member;

public class MemberService {
	MemberDao dao = new MemberDao();

	public List<Member> selectAll() {
		Connection conn = getConnection(); 

		List<Member> list = dao.selectAll(conn);
		
		close(conn);
		
		return list;
	}
	
	public List<Member> selectId(String id) {
		Connection conn = getConnection();
		List<Member> list = dao.selectId(conn, id);
		
		close(conn);
		
		return list;
	}

	public List<Member> selectName(String name) {
		Connection conn = getConnection();
		List<Member> list = dao.selectName(conn, name);
		
		close(conn);
		
		return list;
	}
	
	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result = dao.insertMember(conn, m);
		
		close(conn);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		
		return result;
	}

	public int updateMember(Member m) {
		Connection conn = getConnection();
		int result = dao.updateMember(conn, m);
		
		close(conn);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		
		return result;
	}
	
	public int deleteMember(int idx) {
		Connection conn = getConnection();
		int result = dao.deleteMember(conn, idx);
		
		close(conn);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);
		
		return result;
	}
}
