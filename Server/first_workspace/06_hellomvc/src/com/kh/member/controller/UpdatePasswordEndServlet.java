package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class PasswordUpdateEnd
 */
@WebServlet(name="UpdatePassword", urlPatterns="/member/updatePasswordEnd")
public class UpdatePasswordEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String userId = request.getParameter("userId");
	  String password = request.getParameter("password");
	  String passwordNew = request.getParameter("passwordNew");
	  
	  //패스워드 수정에 대한 서비스 요청
	  //서비스
	  //1. 현재 비밀번호와 일치하는지
	  //2. 일치하면 수정 / 일치하지 않으면 수정 X
	  int result = new MemberService().updatePassword(userId, password, passwordNew);

	  String msg = "";
	  //팝업창~! -> password변경 창으로 가야함!
	  String loc = "/member/updatePassword";
	  String close = "self.close()";

	  switch(result) {
        case 0: msg = "패스워드 수정에 실패! 다시 시도해 주세요."; break;
        case -1: msg="현재패스워드가 일치하지 않습니디."; break;
        default: msg="패스워드 수정완료";
                 request.setAttribute("script", close);break;
	  }
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
