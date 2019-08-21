package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/member/memberUpdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  MemberService service = new MemberService();

	  String userId = request.getParameter("userId");

	  String userName = request.getParameter("userName");
	  char gender= request.getParameter("gender").charAt(0);
	  int age= Integer.valueOf(request.getParameter("age"));
	  String email = request.getParameter("email");
	  String phone= request.getParameter("phone");
	  String address= request.getParameter("address");
	  String hobby= request.getParameter("hobby");

	  Member m = service.selectMember(userId);
	  m.setUserName(userName);
	  m.setGender(gender);
	  m.setAge(age);
	  m.setEmail(email);
	  m.setPhone(phone);
	  m.setAddress(address);
	  m.setHobby(hobby);

	  int result = new MemberService().updateMember(m);
	  if(result >0) {
	    System.out.println("업데이트 성공");
	  }
	  else
	    System.out.println("업데이트 실패");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
