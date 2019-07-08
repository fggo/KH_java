package com.jdbc3.model.service;

import static com.jdbc3.common.JDBCTemplate2.close;
import static com.jdbc3.common.JDBCTemplate2.commit;
import static com.jdbc3.common.JDBCTemplate2.rollback;
import static com.jdbc3.common.JDBCTemplate2.getConnection;

import java.sql.Connection;
import java.util.List;

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
	
	public int insertMember(Member m) {
		Connection conn = getConnection();
		
		int result = dao.insertMember(conn, m);
		
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
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		
		return result;
	}
	
	public int deleteMember(String id) {
		Connection conn = getConnection();
		int result = dao.deleteMember(conn, id);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);

		close(conn);
		
		return result;
	}
}
