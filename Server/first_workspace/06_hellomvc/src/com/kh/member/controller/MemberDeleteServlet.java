package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/member/memberDelete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String id = request.getParameter("userId");
	  int result = new MemberService().deleteMember(id);
	  
	  String msg = result >0? "회원 탈퇴 완료." : "회원 탈퇴 실패.";
	  //로그아웃 시킨 다음 메인화면으로!  탈퇴 실패시 현재 페이지에 그대로.
//	  String loc = result>0? "/logout":"/member/memberUpdate?userId=" + id;
	  String loc = result>0? "/logout":"/mypage?userId=" + id;
	  request.setAttribute("msg", msg);
	  request.setAttribute("loc", loc);

	  RequestDispatcher rd = request.getRequestDispatcher("/views/common/msg.jsp");
      rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
