package com.prac.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.prac.member.model.service.MemberService;
import com.prac.member.model.vo.Member;

/**
 * Servlet implementation class LoginMemberServlet
 */
@WebServlet("/login")
public class LoginMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String id = request.getParameter("id");
	  String pw = request.getParameter("pw");
	  
	  Member m = new MemberService().selectId(id, pw);

	  String view = "";

	  if(m!=null) {
	    HttpSession session = request.getSession();
	    session.setAttribute("loginMember", m);
	    
	    Cookie cookie;

	    view="/";
	    response.sendRedirect(request.getContextPath() + view);
	  }
	  else { //m ==null
	    view = "/views/common/msg.jsg";

	    String msg = "로그인에 실패하였습니다.";
	    String loc = "/";
	    request.setAttribute("msg", msg);
	    request.setAttribute("loc", loc);
	    
	    
	    RequestDispatcher rd = request.getRequestDispatcher(view);
	    rd.forward(request, response);
	  }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
