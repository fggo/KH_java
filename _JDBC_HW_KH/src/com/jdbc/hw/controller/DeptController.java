package com.jdbc.hw.controller;

import java.util.List;

import com.jdbc.hw.model.service.DeptService;
import com.jdbc.hw.model.vo.Department;
import com.jdbc.hw.view.MainView;

public class DeptController {
	private DeptService service = new DeptService();

	public void searchAll() {
		List<Department> list = service.searchAll();
		
		if (list.size() > 0)
			new MainView().displayList(list);
		else
			new MainView().displayMsg("NO DEPT SEARCH RESULT...");
	}
	
	public void insertDept() {
		this.searchAll();
		
		Department dept = new MainView().insertViewDept();
		int result = service.insertDept(dept);
		
		if(result > 0)
			new MainView().displayMsg(result + " ROW(s) INSERT COMPLETE.");
		else
			new MainView().displayMsg("DEPT INSERT FAILED...");
	}
	
	public void updateDept() {
		this.searchAll();
		
		Department dept = new MainView().updateViewDept();
		int result = service.updateDept(dept);
		
		if(result > 0)
			new MainView().displayMsg(result + " ROW(s) UPDATE COMPLETE.");
		else
			new MainView().displayMsg("DEPT UPDATE FAILED...");
	}
	
	public void deleteDept() {
		this.searchAll();
		
		String deptId = new MainView().deleteViewDept();
		int result = service.deleteDept(deptId);
		
		if(result > 0)
			new MainView().displayMsg(result + " ROW(s) DELETE COMPLETE."); 
		else
			new MainView().displayMsg("DEPT DELETE FAILED."); 
	}
}
