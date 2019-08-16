package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

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
    //서블렛 생성시 서버  restart
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //client가 보낸 parameter 값을 받아온다.
	  String id = request.getParameter("userId");
	  String pw = request.getParameter("password");
	  System.out.println(id);
	  System.out.println(pw);

	  //비즈니스 로직
	  MemberService service = new MemberService();
	  Member m = service.selectId(id, pw); //DB결과
	  

	  //DB결과에 따라서 view화면을 선택~
	  String view = "";

	  if(m!=null) {
	    //로그인 처리
	    //2. 로그인의 세션 처리 (로그인을 서버에서 유지하기 위함)
	    HttpSession session = request.getSession();
	    //request.getSession(); 매개변수 true or false
	    //true(default) : 기존에 생성된 객체가 있으면 불러오고, 없으면 생성 해서 불러옴
	    //false : 기존에 생성된 session객체가 있으면 불러오고, 없으면 null값
	    //true(default)값으로 많이 쓰임
	    
	    //로그인 유지를 위해 필요한 정보를 session객체에 저장
	    //session.invalidate()할 때까지 (로그인) 유지됨
	    session.setAttribute("loginMember", m);

	    view = "/"; // 디폴트 "/" url은 index.jsp 연결~


	  }
	  else {
	    //에러 처리
	    //1.메세지 처리 페이지에서 에러메시지를 띄운다.(경고창) 로그인 거절!
	    //2.메인화면으로 이동시킨다.
	    String msg = "아이디나 비밀번호가 일치하지 않습니다.";
	    request.setAttribute("msg", msg);
	    view = "/views/common/msg.jsp";
	    String loc = "/"; //다시 홈으로 이동
	    request.setAttribute("loc", loc);
	  }
	  
	  //request 객체가 Member 오브젝트를 저장함(로그인 성공한 Member instance 또는 실패해서 null)
	  request.setAttribute("loginMember", m);

	  //데이터가 있으면 dispatcher로 전송 (에러로 넘어왔는지 또는 로그인 성공해서 넘어왔는지를)
	  RequestDispatcher rd = request.getRequestDispatcher(view);
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
