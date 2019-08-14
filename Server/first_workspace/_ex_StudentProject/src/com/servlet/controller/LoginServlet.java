package com.servlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.model.service.MemberService;
import com.servlet.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //클라이언트가 보낸 값을 받아옴
	  String id = request.getParameter("id");
	  String pw = request.getParameter("pw");
	  
	  //service에게 확인요청
	  MemberService service = new MemberService();
	  Member m = service.selectId(id, pw);
	  
	  //결과를 받아서 결과에 따른 페이지로 연결
	  if(m != null) {
	    //로그인확인후 세션처리, 로그인 화면으로 이동
//	    HttpSession session = 
	    //DB에서 가져온 값을 request에 넣기
	    request.setAttribute("member", m);
	    //로그인페이지로 전환  : sendRedirect / requestDispatcher(session처리 안함)
	    RequestDispatcher rs = request.getRequestDispatcher("views/loginView.jsp");
	    rs.forward(request, response);
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
