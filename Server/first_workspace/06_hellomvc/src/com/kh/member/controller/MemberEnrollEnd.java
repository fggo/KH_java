package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MemberEnrollEnd
 */
@WebServlet(urlPatterns= "/memberEnrollEnd")
public class MemberEnrollEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEnrollEnd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //client가 보낸값을 db에 저장하고 저장결과를 응답.
//	  USERID VARCHAR2(30) PRIMARY KEY
//	   ,PASSWORD VARCHAR2(300) NOT NULL
//	   ,USERNAME  VARCHAR2(50) NOT NULL
//	   ,GENDER CHAR(1) CHECK (GENDER IN ('M','F'))
//	   ,AGE NUMBER
//	   ,EMAIL VARCHAR2(30)
//	   ,PHONE CHAR(11)  NOT NULL
//	   ,ADDRESS VARCHAR2(100)
//	   ,HOBBY VARCHAR2(80)
//	   ,ENROLLDATE DATE DEFAULT SYSDATE
	   String id = request.getParameter("userId");
	   String pw = request.getParameter("password");
	   String name = request.getParameter("userName");
	   char gender = request.getParameter("gender").charAt(0);
	   int age = Integer.parseInt(request.getParameter("age"));
	   String email = request.getParameter("email");
	   String phone = request.getParameter("phone");
	   String address = request.getParameter("address");
	   String[] hobbies= request.getParameterValues("hobby");
	   
	   Member m = new Member(id, pw, name, gender, age,
	       email,phone, address, String.join(",", hobbies),null);
	   MemberService service = new MemberService();
	   int result = service.insertMember(m);
	   
	   //해당하는 뷰 선택
	   //메세지 보여주고 메인화면으로 이동
	   String msg = "";
	   String loc = "/";
	   msg = result>0? "성공적으로 회원 등록했습니다!" : "회원등록에 실패 했습니다.";
	   
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
