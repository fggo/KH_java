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
 * Servlet implementation class MyPage
 */
@WebServlet("/mypage")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //사용자가 보낸 값 받아오기;
	  String userId = request.getParameter("userId");

	  //비즈니스 로직
	  //userId하고 일치하는 값이 있는지 DB에서 확인하고 있으면 반환해주는 것(일치하는 데이터를)
	  Member m = new MemberService().selectMember(userId);
	  request.setAttribute("member", m);
	  request.getRequestDispatcher("/views/member/mypage.jsp").forward(request, response);

//	  response.sendRedirect(request.getContextPath()+"/views/member/mypage.jsp");
	  //데이터 있을때는 dispatcher로
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
