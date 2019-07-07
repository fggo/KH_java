package com.jdbc.hw.controller;

import java.util.List;

import com.jdbc.hw.model.service.EmpService;
import com.jdbc.hw.model.vo.Department;
import com.jdbc.hw.model.vo.Employee;
import com.jdbc.hw.view.MainView;

public class EmpController {
	private EmpService service = new EmpService();

	public void searchAll() {
		List<Employee> list = service.searchAll();

		if (list.size() > 0)
			new MainView().displayList(list);
		else
			new MainView().displayMsg("NO EMP SEARCH RESULT...");
	}
	
	public void searchById() {
		this.searchAll();

		String emp_id = new MainView().inputData("ID");
		Employee e = service.searchById(emp_id);

		if (e != null)
			new MainView().display(e);
	}

	public void searchByName() { 
		this.searchAll();

		String emp_name = new MainView().inputData("NAME");
		List<Employee> list = service.searchByName(emp_name);
		if(list.size() > 0)
			new MainView().displayList(list);
		else
			new MainView().displayMsg("NO EMP SEARCH RESULT...");
	}

	public void searchByDept() {
		this.searchAll();
		
		String dept_code = new MainView().searchViewByDept();
		List<Employee> list = service.searchByDept(dept_code);
		if(list.size() > 0)
			new MainView().displayList(list);
		else
			new MainView().displayMsg("NO EMP SEARCH RESULT...");
	}

	public void searchBySal() {
		this.searchAll();
		
		int salary = new MainView().searchViewBySalary();
		List<Employee> list = service.searchBySal(salary);

		if(list.size() > 0)
			new MainView().displayList(list);
		else
			new MainView().displayMsg("NO EMP SEARCH RESULT...");
	}
	
	public void insertEmp() {
		this.searchAll();
		
		Employee e = new MainView().insertViewEmp();
		int result = service.insertEmp(e);

		if(result > 0) 
			new MainView().displayMsg(result + " ROW(s) INSERT COMPLETE!");
		else 
			new MainView().displayMsg("EMP INSERT FAILED.");
	}
	
	public void updateEmp() {
		this.searchAll();

		Employee e = new MainView().updateViewEmp();

		int result = service.updateEmp(e);
		
		if(result > 0)
			new MainView().displayMsg(result + " ROW(s) UPDATED!");
		else
			new MainView().displayMsg("EMP UPDATE FAILED.");
	}
	
	public void deleteEmp() {
		this.searchAll();

		String emp_id = new MainView().deleteViewEmp();
		int result = service.deleteEmp(emp_id);
		
		if(result >0)
			new MainView().displayMsg(result + " ROW(s) DELETE COMPLETE!");
		else
			new MainView().displayMsg("EMP DELETE FAILED.");
	}
}
