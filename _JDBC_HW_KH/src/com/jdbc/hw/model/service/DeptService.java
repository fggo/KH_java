package com.jdbc.hw.model.service;

import java.sql.Connection;
import java.util.List;

import static com.jdbc.hw.common.JDBCTemplate.getConnection;
import static com.jdbc.hw.common.JDBCTemplate.close;
import static com.jdbc.hw.common.JDBCTemplate.commit;
import static com.jdbc.hw.common.JDBCTemplate.rollback;
import com.jdbc.hw.model.dao.DeptDao;
import com.jdbc.hw.model.vo.Department;

public class DeptService {
	private DeptDao dao = new DeptDao();

	public List<Department> searchAll(){
		Connection conn = getConnection();
		List<Department> list = dao.searchAll(conn);
		
		close(conn);
		
		return list;
	}
	
	public int insertDept(Department dept) {
		Connection conn = getConnection();
		int result = dao.insertDept(conn, dept);
		
		close(conn);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);

		return result;
	}
	
	public int updateDept(Department dept) {
		Connection conn = getConnection();
		int result = dao.updateDept(conn, dept);
		
		close(conn);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);

		return result;
	}
	
	public int deleteDept(String deptId) {
		Connection conn = getConnection();
		int result = dao.deleteDept(conn, deptId);
		
		close(conn);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);

		return result;
	}
}
