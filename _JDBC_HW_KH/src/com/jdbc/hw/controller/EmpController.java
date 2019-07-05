package com.jdbc.hw.controller;

import java.util.List;

import com.jdbc.hw.model.service.EmployeeService;
import com.jdbc.hw.model.vo.Employee;
import com.jdbc.hw.view.MainView;

public class EmpController {
	private EmployeeService service = new EmployeeService();

	public void searchAll() {
		List<Employee> list = service.searchAll();

		if (list.size() > 0)
			new MainView().displayEmpAll(list);
		else
			new MainView().displayMsg("NO EMP SEARCH RESULT...");
	}
	
	public void searchById() {
		this.searchAll();

		String emp_id = new MainView().inputData("ID");
		Employee e = service.searchById(emp_id);

		if (e != null)
			new MainView().displayEmp(e);
	}

	public void searchByName() { 
		this.searchAll();

		String emp_name = new MainView().inputData("NAME");
		List<Employee> list = service.searchByName(emp_name);
		if(list.size() > 0)
			new MainView().displayEmpAll(list);
		else
			new MainView().displayMsg("NO EMP SEARCH RESULT...");
	}

	public void searchByDept() {
		this.searchAll();
		
		String dept_code = new MainView().searchViewByDept();
		List<Employee> list = service.searchByDept(dept_code);
		if(list.size() > 0)
			new MainView().displayEmpAll(list);
		else
			new MainView().displayMsg("NO EMP SEARCH RESULT...");
	}

	public void searchBySal() {
		this.searchAll();
		
		int salary = new MainView().searchViewBySalary();
		List<Employee> list = service.searchBySal(salary);

		if(list.size() > 0)
			new MainView().displayEmpAll(list);
		else
			new MainView().displayMsg("NO EMP SEARCH RESULT...");
	}
	
	public void insertEmp() {
		Employee e = new MainView().insertViewEmp();
		int result = service.insertEmp(e);

		if(result > 0) 
			new MainView().displayMsg(result + " row(s) INSERT COMPLETE!");
		else 
			new MainView().displayMsg("INSERT FAILED!");
	}
	
	public void updateEmp() {
		this.searchAll();

		Employee e = new MainView().updateViewEmp();

		int result = service.updateEmp(e);
		
		if(result > 0)
			new MainView().displayMsg(result + " ROW(s) UPDATED!");
		else
			new MainView().displayMsg("UPDATE FAILED!");
	}
	
	public void deleteEmp() {
		this.searchAll();

		String emp_id = new MainView().deleteViewEmp();
		int result = service.deleteEmp(emp_id);
		
		if(result >0)
			new MainView().displayMsg(result + " ROW(s) DELETE COMPLETE!");
		else
			new MainView().displayMsg("DELETE FAILED...");
	}
}
