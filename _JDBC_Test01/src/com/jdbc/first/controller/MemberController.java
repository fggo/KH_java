package com.jdbc.first.controller;

import java.util.List;
import java.util.Map;

import com.jdbc.first.model.dao.MemberDao;
import com.jdbc.first.model.vo.Member;
import com.jdbc.first.view.MainView;

public class MemberController {
	public void memberAllSearch() {
		List<Member> list = new MemberDao().selectAll();
		//System.out.println(list);// View에 있는 displayMember로 보내야함
		//view에서 화면을 고름
		new MainView().displayMember(list);
	}
	
	//이름을 클라이언트에게 받아서, 이름을 기준으로 DB에서 회원을 조회 
	public void memberNameSearch() {
		//client에게 name input 받음
		String name = new MainView().inputData("NAME");
		//클라이언트 입력값 name으로 Dao에 데이터 query 요청
		List<Member> list = new MemberDao().selectName(name);
		new MainView().displayMember(list);
	}
	
	public void memberIdSearch() {
		String id = new MainView().inputData("ID");
		List<Member> list = new MemberDao().selectId(id);
		new MainView().displayMember(list);
		
	}
	
	//DB Member Table에 회원정보를 입력
	public void memberInsert() {
		Member m = new MainView().insertMember();
		int result= new MemberDao().insertMember(m);
		System.out.println(result + " ROWS INSERTED.");
	}
	
	//MODIFY name, age, address, hobby 
	public void memberUpdate() {
		this.memberAllSearch();

		String id = new MainView().inputData("ID");
		Member m = new MainView().updateView();
		m.setMemberId(id);
		int result = new MemberDao().updateMember(m);
		String msg= "";
		if(result>0) {
			msg = m.getMemberId() + " INFO UPDATED.";
		}
		else {
			msg = m.getMemberId() + " INFO UPDATE FAILED. TRY AGAIN!";
		}
		new MainView().displayMsg(msg);
	}
	
	public void memberDelete() {
		this.memberAllSearch();

		String id = new MainView().deleteMember();
		int result = new MemberDao().deleteMember(id);
		
		String msg = "";
		if(result > 0)
			msg = id + " DELETE SUCCESSFUL!";
		else
			msg = id + " DELETE FAILED!";
		new MainView().displayMsg(msg);
	}
	
}
