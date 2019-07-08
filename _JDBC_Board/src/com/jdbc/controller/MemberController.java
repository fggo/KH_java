package com.jdbc.controller;

import java.util.List;

import com.jdbc.model.service.MemberService;
import com.jdbc.model.vo.Member;
import com.jdbc.view.MainView;

public class MemberController {
	MemberService service = new MemberService();

	public void selectAll() {
		List<Member> list = service.selectAll();
		if (list.size() > 0)
			new MainView().displayList(list);
		else
			new MainView().displayMsg("NO MEMBER SELECT RESULT...");
	}
	
	public void selectId() {
		this.selectAll();

		String id = new MainView().inputData("ID");
		List<Member> list = service.selectId(id);
		
		if(list.size() >0)
			new MainView().display(list);
		else
			new MainView().displayMsg("NO MEMBER ID SEARCH RESULT...");
		
	}

	public void selectName() {
		this.selectAll();

		String name = new MainView().inputData("NAME");
		List<Member> list = service.selectName(name);
		
		if(list.size() > 0)
			new MainView().display(list);
		else
			new MainView().displayMsg("NO MEMBER NAME SEARCH RESULT...");
	}
	
	public void insertMember() {
		this.selectAll();

		Member m = new MainView().insertMember();
		int result = service.insertMember(m);

		String msg = result > 0 ? result + " ROW(s) INSERT COMPLETE" 
				: "MEMBER INSERT FAILED...";

		new MainView().displayMsg(msg);
	}

	public void updateMember() {
		this.selectAll();

		Member m = new MainView().updateMember();
		int result = service.updateMember(m);

		String msg = result > 0 ? result + " ROW(s) UPDATE COMPLETE" 
				: "MEMBER UPDATE FAILED...";

		new MainView().displayMsg(msg);
	}

	public void deleteMember() {
		this.selectAll();

		int idx = Integer.valueOf(new MainView().inputData("IDX"));
		int result = service.deleteMember(idx);

		String msg = result > 0 ? result + " ROW(s) DELETE COMPLETE" 
				: "MEMBER DELETE FAILED...";

		new MainView().displayMsg(msg);
	}
	
}
