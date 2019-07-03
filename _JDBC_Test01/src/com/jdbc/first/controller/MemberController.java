package com.jdbc.first.controller;

import java.util.List;

import com.jdbc.first.model.dao.MemberDao;
import com.jdbc.first.model.vo.Member;

public class MemberController {
	public void memberAllSearch() {
		List<Member> list = new MemberDao().selectAll();
		System.out.println(list);// View에 있는 displayMember로 보내야함
	}
}
