package com.jdbc.hw.controller;

import java.util.List;

import com.jdbc.hw.model.dao.EmployeeDao;
import com.jdbc.hw.model.vo.Employee;
import com.jdbc.hw.view.MainView;

public class EmpController {
	public void searchAll() {
		List<Employee> list = new EmployeeDao().searchAll();
		for(Employee e : list) {
			System.out.println(e);
		}
	}
	
	public void searchById() {
		this.searchAll();

		String emp_id = new MainView().searchViewById();
		Employee e =new EmployeeDao().searchById(emp_id);
		System.out.println(e);
	}

	public void searchByName() { 
		this.searchAll();

		String emp_name = new MainView().searchViewByName();
		List<Employee> list = new EmployeeDao().searchByName(emp_name);
		for(Employee e : list)
			System.out.println(e);
	}

	public void searchByDept() {
		this.searchAll();
		
		String dept_code = new MainView().searchViewByDept();
		List<Employee> list = new EmployeeDao().searchByDept(dept_code);
		for(Employee e : list)
			System.out.println(e);
	}

	public void searchBySal() {
		this.searchAll();
		
		int salary = new MainView().searchViewBySalary();
		List<Employee> list = new EmployeeDao().searchBySalary(salary);
		for(Employee e : list)
			System.out.println(e);
	}
	
	public void insertEmp() {
		Employee e = new MainView().insertViewEmp();
		int result = new EmployeeDao().insertEmp(e);

		if(result > 0) {
			System.out.println(result + " row(s) INSERT COMPLETE!");
		}
		else {
			System.out.println("INSERT FAILED!");
		}
	}
	
	public void updateEmp() {
//		Employee e = new MainView().updateViewEmp();
//		int result = new EmployeeDao().updateEmp(e);
//		
//		if(result > 0) {
//			System.out.println(result + " ROW(s) UPDATED!");
//		}
//		else
//			System.out.println("UPDATE FAILED!");
		
	}
	
	public void deleteEmp() {
		String emp_id = new MainView().deleteViewEmp();
		int result = new EmployeeDao().deleteEmp(emp_id);
		
		if(result >0)
			System.out.println(result + " ROW(s) DELETE COMPLETE!");
		else
			System.out.println("DELETE FAILED...");
	}
}
