package com.jdbc2.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.jdbc2.model.vo.Employee;

public class EmpDao {
	public List<Employee> selectAll(){
		Connection conn = EmpDao.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Employee> list = new ArrayList<Employee>();
		Employee emp = null;
		
		try {
			String sql = "SELECT * FROM EMPLOYEE";
			// PreparedStatement
			// 이미 쿼리문을 내부적으로 생성해서 가지고 있는 상태에서
			// 내가 필요한 속성값(컬럼값)을 세팅하게 되어있음
			// 생성할때 매개변수로 사용할 쿼리문을 대입
			pstmt = conn.prepareStatement(sql);
//			psmt.setString();
//			psmt.setInt();
//			psmt.setDate();
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emp = new Employee();
				
				emp.setEmpId(rs.getString("emp_id"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setEmpNo(rs.getString("emp_no"));
				emp.setEmail(rs.getString("email"));
				emp.setPhone(rs.getString("phone"));
				emp.setDeptCode(rs.getString("dept_code"));
				emp.setJobCode(rs.getString("job_code"));
				emp.setSalLevel(rs.getString("sal_level"));
				emp.setSalary(rs.getInt("salary"));
				emp.setBonus(rs.getDouble("bonus"));
				emp.setManagerId(rs.getString("manager_id"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setEntDate(rs.getDate("ent_date"));
				emp.setEntYn(rs.getString("ent_yn").charAt(0));
				
				
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
	
	public Employee selectId(String id) {
		Connection conn = EmpDao.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Employee emp = null;

		String sql = "SELECT * FROM EMPLOYEE WHERE emp_id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			//pstmt 위치홀더(?)로 표시된 것으로 세팅해줘야 함
			//setString() setInt() setDate()
			//2개의 매개변수를 갖는다.
			//첫번째 매개변수: 순서 ? 가 작성된 순서대로 1번부터시작....
			//두번째 매개변수: 순서에 들어갈값(리터럴)
			//위치홀더를 선언한것은 모두 세팅!!!
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				emp = new Employee();
				
				emp.setEmpId(rs.getString("emp_id"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setEmpNo(rs.getString("emp_no"));
				emp.setEmail(rs.getString("email"));
				emp.setPhone(rs.getString("phone"));
				emp.setDeptCode(rs.getString("dept_code"));
				emp.setJobCode(rs.getString("job_code"));
				emp.setSalLevel(rs.getString("sal_level"));
				emp.setSalary(rs.getInt("salary"));
				emp.setBonus(rs.getDouble("bonus"));
				emp.setManagerId(rs.getString("manager_id"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setEntDate(rs.getDate("ent_date"));
				emp.setEntYn(rs.getString("ent_yn").charAt(0));
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
	
	public List<Employee> selectName(String name) {
		Connection conn = EmpDao.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Employee> list = new ArrayList<Employee>();

		Employee emp = null;
		try {
			String sql = "SELECT * FROM EMPLOYEE WHERE emp_name like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				emp = new Employee();
				
				emp.setEmpId(rs.getString("emp_id"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setEmpNo(rs.getString("emp_no"));
				emp.setEmail(rs.getString("email"));
				emp.setPhone(rs.getString("phone"));
				emp.setDeptCode(rs.getString("dept_code"));
				emp.setJobCode(rs.getString("job_code"));
				emp.setSalLevel(rs.getString("sal_level"));
				emp.setSalary(rs.getInt("salary"));
				emp.setBonus(rs.getDouble("bonus"));
				emp.setManagerId(rs.getString("manager_id"));
				emp.setHireDate(rs.getDate("hire_date"));
				emp.setEntDate(rs.getDate("ent_date"));
				emp.setEntYn(rs.getString("ent_yn").charAt(0));
				
				list.add(emp);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}

		return list;
	}
	
	public int insertEmp(Employee emp) {
		Connection conn = EmpDao.getConnection();
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
			
			if(result > 0)
				conn.commit();
			else
				conn.rollback();

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
	
	private static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kh", "kh");
			conn.setAutoCommit(false);
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
