package com.jdbc.hw.model.service;

import java.sql.Connection;
import java.util.List;

import static com.jdbc.hw.common.JDBCTemplate.close;
import static com.jdbc.hw.common.JDBCTemplate.commit;
import static com.jdbc.hw.common.JDBCTemplate.rollback;
import static com.jdbc.hw.common.JDBCTemplate.getConnection;
import com.jdbc.hw.model.dao.EmployeeDao;
import com.jdbc.hw.model.vo.Employee;

public class EmployeeService {
	private EmployeeDao dao = new EmployeeDao();
	
	public List<Employee> searchAll(){
		Connection conn = getConnection();
		List<Employee> list = dao.searchAll(conn);

		close(conn);

		return list;
	}
	
	public Employee searchById(String id) {
		Connection conn = getConnection();
		Employee e = dao.searchById(conn, id);
		
		close(conn);

		return e;
	}
	
	public List<Employee> searchByName(String name) {
		Connection conn = getConnection();
		List<Employee> list = dao.searchByName(conn, name);
		
		close(conn);

		return list;
	}

	public List<Employee> searchByDept(String dept_code) {
		Connection conn = getConnection();
		List<Employee> list = dao.searchByDept(conn, dept_code);
		
		close(conn);
		
		return list;
	}

	public List<Employee> searchBySal(int salary){
		Connection conn = getConnection();
		List<Employee> list = dao.searchBySal(conn, salary);
		
		close(conn);
		
		return list;
	}
	
	public int insertEmp(Employee emp) {
		Connection conn = getConnection();
		int result = dao.insertEmp(conn, emp);

		close(conn);
		
		if(result >0)
			commit(conn);
		else
			rollback(conn);
		
		return result;
	}
	
	public int updateEmp(Employee e) {
		Connection conn = getConnection();
		int result = dao.updateEmp(conn, e);

		close(conn);
		
		if(result > 0)
			commit(conn);
		else
			rollback(conn);

		return result;
	}

	public int deleteEmp(String emp_id) {
		Connection conn = getConnection();
		int result = dao.deleteEmp(conn, emp_id);

		close(conn);
		
		if(result >0)
			commit(conn);
		else
			rollback(conn);
		
		return result;
	}
}
