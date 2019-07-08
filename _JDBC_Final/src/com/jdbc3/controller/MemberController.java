package com.jdbc3.controller;

import java.util.List;

import com.jdbc3.model.service.MemberService;
import com.jdbc3.model.vo.Member;
import com.jdbc3.view.MainView;

public class MemberController {
	private MemberService service = new MemberService();

	public void selectAll() {
		List<Member> list = service.selectAll();

		if(list.size() > 0)
			new MainView().displayMemberList(list);
		else
			new MainView().displayMsg("NO SEARCH RESULT...");
	}

	public void selectId() {
		String id = new MainView().inputData("ID");
		Member m = service.selectId(id);
		
		//VIEW 화면
		if (m != null)
			new MainView().displayMember(m);
		else
			new MainView().displayMsg("NO SEARCH RESULT...");
	}

	public void selectName() {
		String name = new MainView().inputData("NAME");
		List<Member> list = service.selectName(name);
		
		if(list.isEmpty()) {
			new MainView().displayMsg("NO SEARCH RESULT...");
		}
		else {
			new MainView().displayMemberList(list);
		}
	}
	
	public void insertMember() {
		Member m = new MainView().inputMember();
		int result = service.insertMember(m);
		
		String msg = result >0? result + " ROW(s) INSERT COMPLETE" 
				: "MEMBER INSERT FAILED";

		new MainView().displayMsg(msg);
	}
	
	public void updateMember() {
		String id = new MainView().inputData("ID");
		Member m = new MainView().updateMember(id);
		int result = service.updateMember(m);
		
		
		String msg = result >0? result + " ROW(s) UPDATE COMPLETE" 
				: "MEMBER UPDATE FAILED";

		new MainView().displayMsg(msg);
	}
	
	public void deleteMember() {
		String id = new MainView().inputData("ID");
		int result = service.deleteMember(id);
		
		String msg = result >0? result + " ROW(s) DELETE COMPLETE" 
				: "MEMBER DELETE FAILED";

		new MainView().displayMsg(msg);
	}
}
