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
@WebServlet(name="MemberUpdate", urlPatterns="/member/memberUpdate")
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
	  Member m = new Member();
	  m.setUserId(request.getParameter("userId"));
	  m.setUserName(request.getParameter("userName"));
	  m.setGender(request.getParameter("gender").charAt(0));
	  m.setAge(Integer.valueOf(request.getParameter("age")));
	  m.setEmail(request.getParameter("email"));
	  m.setPhone(request.getParameter("phone"));
	  m.setAddress(request.getParameter("address"));
	  m.setHobby(String.join(",", request.getParameterValues("hobby")));

	  int result = new MemberService().updateMember(m);
	  
	  String msg = result>0? "회원수정이 완료되었습니다." : "회원수정이 싱패하였습니다.";
//	  String loc = "/"; //홈으로 이동
	  String loc = "/mypage?userId=" + m.getUserId();

	  request.setAttribute("msg", msg);
	  request.setAttribute("loc", loc);
	  request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
