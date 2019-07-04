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
		Statement stmt = null;
		ResultSet rs = null;

		Employee emp = null;
		List<Employee> list = new ArrayList<Employee>();

		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM EMPLOYEE";
			rs = stmt.executeQuery(sql);

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
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}
	
	public Employee searchById(String emp_id) {
		Connection conn = EmployeeDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		Employee emp = new Employee();

		try {
			stmt = conn.createStatement();
			String sql = "select * from employee where emp_id='" + emp_id+"'";
			rs = stmt.executeQuery(sql);
			rs.next();
			
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
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	public List<Employee> searchByName(String emp_name) {
		Connection conn = EmployeeDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		Employee emp = null;
		List<Employee> list = new ArrayList<Employee>();

		try {
			stmt = conn.createStatement();
			String sql = "select * from employee where emp_name='" + emp_name +"'";
			rs = stmt.executeQuery(sql);

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
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<Employee> searchByDept(String dept_code) {
		Connection conn = EmployeeDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		Employee emp = null;
		List<Employee> list = new ArrayList<Employee>();

		try {
			stmt = conn.createStatement();
			String sql = "select * from employee where dept_code='" + dept_code +"'";
			rs = stmt.executeQuery(sql);

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
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
		
	}
	
	public List<Employee> searchBySalary(int salary) {
		Connection conn = EmployeeDao.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		Employee emp = null;
		List<Employee> list = new ArrayList<Employee>();

		try {
			stmt = conn.createStatement();
			String sql = "select * from employee where salary>=" + salary;
			rs = stmt.executeQuery(sql);
			
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
				stmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int insertEmp(Employee emp) {
		Connection conn = EmployeeDao.getConnection();
		PreparedStatement prep_stmt = null;

		int result = 0;

		try {
			String sql = "INSERT INTO EMPLOYEE(emp_id, emp_name, emp_no, email,"
					+ "phone, dept_code, job_code, sal_level, salary, bonus, manager_id, hire_date)"
					+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

			prep_stmt = conn.prepareStatement(sql);

			prep_stmt.setString(1, emp.getEmp_id());
			prep_stmt.setString(2, emp.getEmp_name());
			prep_stmt.setString(3, emp.getEmp_no());
			prep_stmt.setString(4, emp.getEmail());
			prep_stmt.setString(5, emp.getPhone());
			prep_stmt.setString(6, emp.getDept_code());
			prep_stmt.setString(7, emp.getJob_code());
			prep_stmt.setString(8, emp.getSal_level());
			prep_stmt.setInt(9, emp.getSalary());
			prep_stmt.setDouble(10, emp.getBonus());
			prep_stmt.setString(11, emp.getManager_id());
			prep_stmt.setDate(12, new java.sql.Date(emp.getHire_date().getTime()));

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
