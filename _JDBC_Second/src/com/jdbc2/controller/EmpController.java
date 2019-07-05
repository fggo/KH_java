package com.jdbc2.controller;

import java.util.List;

import com.jdbc2.model.dao.EmpDao;
import com.jdbc2.model.vo.Employee;
import com.jdbc2.view.MainView;

public class EmpController {
	private EmpDao dao = new EmpDao();

	public void selectAll() {
		List<Employee> list = dao.selectAll();
		if(list.size() > 0) {
			new MainView().displayEmployeeAll(list);
		}
		else {
			new MainView().displayMsg("NO SERACH RESULT...");
		}
	}
	
	public void selectId() {
		this.selectAll();

		String id = new MainView().inputData("ID");
		Employee e = dao.selectId(id);
		
		if(e == null)
			new MainView().displayMsg("NO SEARCH RESULT...");
		else
			new MainView().displayEmployee(e);
	}
	
	public void selectName() {
		this.selectAll();
		
		String name = new MainView().inputData("NAME");
		List<Employee> list = dao.selectName(name);

		if(list.isEmpty())
			new MainView().displayMsg("NO SEARCH RESULT");
		else
			new MainView().displayEmployeeAll(list);
	}
	
	public void insertEmp() {
		this.selectAll();

		Employee e = new MainView().inputEmp();
		int result = dao.insertEmp(e);
		String msg = "";
		
		if(result > 0) {
			msg = result + " ROW(s) INSERT COMPLETE!";
		}
		else
			msg = "INSERT FAILED!";
		
		new MainView().displayMsg(msg);
	}
	
	public void deleteEmp() {
		this.selectAll();
		
//		String id = new MainView().deleteViewEmp();
//		int result = dao.deleteEmp(id);
//		
//		String msg = "";
//
//		if(result>0) {
//			msg = result + " ROW(s) DELETE COMPLETE!";
//		}
//		else {
//			msg = "DELETE FAILED!";
//		}
	}

}
