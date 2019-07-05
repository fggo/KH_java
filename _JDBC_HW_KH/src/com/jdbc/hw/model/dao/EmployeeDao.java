package com.jdbc.hw.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.jdbc.hw.common.JDBCTemplate.close;
import com.jdbc.hw.model.vo.Employee;

public class EmployeeDao {
	public List<Employee> searchAll(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Employee> list = new ArrayList<Employee>();

		try {
			String sql = "SELECT * FROM EMPLOYEE";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			list = this.initEmployeeList(rs);

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return list;
	}

	public Employee searchById(Connection conn, String emp_id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Employee emp = new Employee();

		try {
			String sql = "select * from employee where emp_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);

			rs = pstmt.executeQuery();

			emp = this.initEmployee(rs);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return emp;
	}

	public List<Employee> searchByName(Connection conn, String emp_name) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Employee> list = new ArrayList<Employee>();

		try {
			String sql = "select * from employee where emp_name LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + emp_name + "%");

			rs = pstmt.executeQuery();

			list = this.initEmployeeList(rs);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public List<Employee> searchByDept(Connection conn, String dept_code) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Employee> list = new ArrayList<Employee>();

		try {
			String sql = "select * from employee where dept_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept_code);
			rs = pstmt.executeQuery();

			list = this.initEmployeeList(rs);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
		
	}
	
	public List<Employee> searchBySal(Connection conn, int salary) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Employee> list = new ArrayList<Employee>();

		try {
			String sql = "select * from employee where salary >= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, salary);
			rs = pstmt.executeQuery();
			
			list = this.initEmployeeList(rs);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}

	public int insertEmp(Connection conn, Employee emp) {
		PreparedStatement pstmt = null;

		int result = 0;

		try {
			String sql = "INSERT INTO EMPLOYEE "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?, SYSDATE , NULL, DEFAULT)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, emp.getEmpId());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getEmpNo());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhone());
			pstmt.setString(6, emp.getDeptCode());
			pstmt.setString(7, emp.getJobCode());
			pstmt.setString(8, emp.getSalLevel());
			pstmt.setInt(9, emp.getSalary());
			pstmt.setDouble(10, emp.getBonus());
			pstmt.setString(11, emp.getManagerId());

			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public int updateEmp(Connection conn, Employee emp) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "UPDATE EMPLOYEE SET emp_name=?, EMAIL=? WHERE emp_id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, emp.getEmpName());
			pstmt.setString(2, emp.getEmail());
			pstmt.setString(3, emp.getEmpId());
			
			result = pstmt.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteEmp(Connection conn, String emp_id) {
		PreparedStatement pstmt = null;

		int result = 0;

		try {
			String sql = "DELETE FROM EMPLOYEE WHERE emp_id=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);

			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	private Employee initEmployee(ResultSet rs) {
		Employee e = null;
		
		try {
			if(rs.next()) {
				e = new Employee();
				
				e.setEmpId(rs.getString("emp_id"));
				e.setEmpName(rs.getString("emp_name"));
				e.setEmpNo(rs.getString("emp_no"));
				e.setEmail(rs.getString("email"));
				e.setPhone(rs.getString("phone"));
				e.setDeptCode(rs.getString("dept_code"));
				e.setJobCode(rs.getString("job_code"));
				e.setSalLevel(rs.getString("sal_level"));
				e.setSalary(rs.getInt("salary"));
				e.setBonus(rs.getDouble("bonus"));
				e.setManagerId(rs.getString("manager_id"));
				e.setHireDate(rs.getDate("hire_date"));
				e.setEntDate(rs.getDate("ent_date"));
				e.setEntYn(rs.getString("ent_yn"));
			}
		} catch(SQLException err) {
			err.printStackTrace();
		}
		return e;
	}

	private List<Employee> initEmployeeList(ResultSet rs) {
		List<Employee> list = new ArrayList<Employee>();
		Employee e = null;
		
		try {
			while(rs.next()) {
				e = new Employee();
				
				e.setEmpId(rs.getString("emp_id"));
				e.setEmpName(rs.getString("emp_name"));
				e.setEmpNo(rs.getString("emp_no"));
				e.setEmail(rs.getString("email"));
				e.setPhone(rs.getString("phone"));
				e.setDeptCode(rs.getString("dept_code"));
				e.setJobCode(rs.getString("job_code"));
				e.setSalLevel(rs.getString("sal_level"));
				e.setSalary(rs.getInt("salary"));
				e.setBonus(rs.getDouble("bonus"));
				e.setManagerId(rs.getString("manager_id"));
				e.setHireDate(rs.getDate("hire_date"));
				e.setEntDate(rs.getDate("ent_date"));
				e.setEntYn(rs.getString("ent_yn"));

				list.add(e);
			}
		} catch(SQLException err) {
			err.printStackTrace();
		}
		return list;
	}
}
