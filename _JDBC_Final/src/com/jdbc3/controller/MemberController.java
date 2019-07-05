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
			new MainView().displayMemberAll(list);
		else
			new MainView().displayMsg("조회된 결과가 없습니다.");
	}

	public void selectId() {
		String id = new MainView().inputData("ID");
		Member m = service.selectId(id);
		
		if (m != null)
			new MainView().displayMember(m);
		
	}

	public void selectName() {
		String name = new MainView().inputData("NAME");
		List<Member> list = service.selectName(name);

		if(list.size() > 0)
			new MainView().displayMemberAll(list);
		else
			new MainView().displayMsg("조회된 결과가 없습니다.");
	}
}
