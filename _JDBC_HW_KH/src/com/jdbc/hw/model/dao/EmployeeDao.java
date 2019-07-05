package com.jdbc.hw.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.hw.model.vo.Employee;

public class EmployeeDao {
	public List<Employee> searchAll() {
		Connection conn = EmployeeDao.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Employee emp = null;
		List<Employee> list = new ArrayList<Employee>();

		try {
			String sql = "SELECT * FROM EMPLOYEE";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				emp = new Employee();

				emp.setEmp_id(rs.getString("emp_id"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setEmp_no(rs.getString("emp_no"));
				emp.setEmail(rs.getString("email"));
				emp.setPhone(rs.getString("phone"));
				emp.setDept_code(rs.getString("dept_code"));
				emp.setJob_code(rs.getString("job_code"));
				emp.setSal_level(rs.getString("sal_level"));
				emp.setSalary(rs.getInt("salary"));
				emp.setBonus(rs.getDouble("bonus"));
				emp.setManager_id(rs.getString("manager_id"));
				emp.setHire_date(rs.getDate("hire_date"));
				emp.setEnt_date(rs.getDate("ent_date"));
				emp.setEnt_yn(rs.getString("ent_yn"));

				list.add(emp);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
	
	public Employee searchById(String emp_id) {
		Connection conn = EmployeeDao.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Employee emp = new Employee();

		try {
			String sql = "select * from employee where emp_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp_id);

			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				emp.setEmp_id(rs.getString("emp_id"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setEmp_no(rs.getString("emp_no"));
				emp.setEmail(rs.getString("email"));
				emp.setPhone(rs.getString("phone"));
				emp.setDept_code(rs.getString("dept_code"));
				emp.setJob_code(rs.getString("job_code"));
				emp.setSal_level(rs.getString("sal_level"));
				emp.setSalary(rs.getInt("salary"));
				emp.setBonus(rs.getDouble("bonus"));
				emp.setManager_id(rs.getString("manager_id"));
				emp.setHire_date(rs.getDate("hire_date"));
				emp.setEnt_date(rs.getDate("ent_date"));
				emp.setEnt_yn(rs.getString("ent_yn"));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	public List<Employee> searchByName(String emp_name) {
		Connection conn = EmployeeDao.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Employee emp = null;
		List<Employee> list = new ArrayList<Employee>();

		try {
			String sql = "select * from employee where emp_name LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + emp_name + "%");

			rs = pstmt.executeQuery();

			while(rs.next()) {
				emp = new Employee();

				emp.setEmp_id(rs.getString("emp_id"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setEmp_no(rs.getString("emp_no"));
				emp.setEmail(rs.getString("email"));
				emp.setPhone(rs.getString("phone"));
				emp.setDept_code(rs.getString("dept_code"));
				emp.setJob_code(rs.getString("job_code"));
				emp.setSal_level(rs.getString("sal_level"));
				emp.setSalary(rs.getInt("salary"));
				emp.setBonus(rs.getDouble("bonus"));
				emp.setManager_id(rs.getString("manager_id"));
				emp.setHire_date(rs.getDate("hire_date"));
				emp.setEnt_date(rs.getDate("ent_date"));
				emp.setEnt_yn(rs.getString("ent_yn"));

				list.add(emp);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<Employee> searchByDept(String dept_code) {
		Connection conn = EmployeeDao.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Employee emp = null;
		List<Employee> list = new ArrayList<Employee>();

		try {
			String sql = "select * from employee where dept_code=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dept_code);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				emp = new Employee();

				emp.setEmp_id(rs.getString("emp_id"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setEmp_no(rs.getString("emp_no"));
				emp.setEmail(rs.getString("email"));
				emp.setPhone(rs.getString("phone"));
				emp.setDept_code(rs.getString("dept_code"));
				emp.setJob_code(rs.getString("job_code"));
				emp.setSal_level(rs.getString("sal_level"));
				emp.setSalary(rs.getInt("salary"));
				emp.setBonus(rs.getDouble("bonus"));
				emp.setManager_id(rs.getString("manager_id"));
				emp.setHire_date(rs.getDate("hire_date"));
				emp.setEnt_date(rs.getDate("ent_date"));
				emp.setEnt_yn(rs.getString("ent_yn"));

				list.add(emp);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}
	
	public List<Employee> searchBySalary(int salary) {
		Connection conn = EmployeeDao.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Employee emp = null;
		List<Employee> list = new ArrayList<Employee>();

		try {
			String sql = "select * from employee where salary >= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, salary);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emp = new Employee();

				emp.setEmp_id(rs.getString("emp_id"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setEmp_no(rs.getString("emp_no"));
				emp.setEmail(rs.getString("email"));
				emp.setPhone(rs.getString("phone"));
				emp.setDept_code(rs.getString("dept_code"));
				emp.setJob_code(rs.getString("job_code"));
				emp.setSal_level(rs.getString("sal_level"));
				emp.setSalary(rs.getInt("salary"));
				emp.setBonus(rs.getDouble("bonus"));
				emp.setManager_id(rs.getString("manager_id"));
				emp.setHire_date(rs.getDate("hire_date"));
				emp.setEnt_date(rs.getDate("ent_date"));
				emp.setEnt_yn(rs.getString("ent_yn"));
				
				list.add(emp);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int insertEmp(Employee emp) {
		Connection conn = EmployeeDao.getConnection();
		PreparedStatement pstmt = null;

		int result = 0;

		try {
			String sql = "INSERT INTO EMPLOYEE "
					+ "VALUES(?,?,?,?,?,?,?,?,?,?,?, SYSDATE , NULL, DEFAULT)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, emp.getEmp_id());
			pstmt.setString(2, emp.getEmp_name());
			pstmt.setString(3, emp.getEmp_no());
			pstmt.setString(4, emp.getEmail());
			pstmt.setString(5, emp.getPhone());
			pstmt.setString(6, emp.getDept_code());
			pstmt.setString(7, emp.getJob_code());
			pstmt.setString(8, emp.getSal_level());
			pstmt.setInt(9, emp.getSalary());
			pstmt.setDouble(10, emp.getBonus());
			pstmt.setString(11, emp.getManager_id());

			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}
			else {
				conn.rollback();
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public int deleteEmp(String emp_id) {
		Connection conn = EmployeeDao.getConnection();
		PreparedStatement prep_stmt = null;

		int result = 0;

		try {
			String sql = "DELETE FROM EMPLOYEE WHERE emp_id=?";

			prep_stmt = conn.prepareStatement(sql);
			prep_stmt.setString(1, emp_id);

			result = prep_stmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			}
			else {
				conn.rollback();
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				prep_stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
		
	}

	private static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh","kh");
			conn.setAutoCommit(false);
			conn.commit();
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
