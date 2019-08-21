package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
	  System.out.println(m);
	  

	  //DB결과에 따라서 view화면을 선택~
	  String view = "";

	  if(m!=null) {
	    //로그인 처리
	    //2. 로그인의 세션 처리 (로그인을 서버에서 유지하기 위함)
	    HttpSession session = request.getSession();

	    //session id값으로 요청 ->WAS에서 새 아이디값 부여(listener가 듣게됨!)

	    //Session life cycle:
	    //session객체는 getSession()객체 생성 했을때 생성, session.invalidate()할때 소멸
	    //1. Server\Tomcat.xx.xx\web.xml : <session-config> WAS가 설정
	    //<session-config>
	    //    <session-timeout>30</session-timeout> //분단위
	    //</session-config>
	    //2. 또는 session객체로 설정가능 : 코드값이 web.xml 설정보다 우선시 됨!!!!
	    //session.setMaxInactiveInterval(interval); //초단위 : 일정 시간 이후 세션종료(session.invalidate()실행!)!
	    //session.setMaxInactiveInterval(60);//session 유지 for 60 sec //e.g. bank application
	    //session listener 설정 : session이 동작하는 event tracking //e.g. alert when session disconnect

	    //request.getSession(boolean); 매개변수 true or false
	    //true(default) : 기존에 생성된 객체가 있으면 불러오고, 없으면 생성 해서 불러옴
	    //false : 기존에 생성된 session객체가 있으면 불러오고, 없으면 null값
	    //true(default)값으로 많이 쓰임
	    
	    //session.invalidate()할 때까지 (로그인) 유지됨
	    //로그인 유지를 위해 필요한 정보를 session객체에 저장 :
	    session.setAttribute("loginMember", m);
	    
	    
	    //쿠키에 아이디 저장하기
	    String saveId = request.getParameter("saveId");
	    System.out.println("saveId" + saveId);
	    //saveId check가 되면 "on"
	    //saveId check안되면 null
	    if(saveId != null) {
	      //쿠키에 저장하는 방법
	      //1. 쿠키객체를 생성!, 생성자 매개변수: 쿠키의 명칭과 값을 대입
	      //첫번째 매개변수: key, 두번째 매개변수 value
	      Cookie c = new Cookie("saveId", id);
	      //일주일 동안  id저장
	      c.setMaxAge(7*24*60*60); //seconds 초단위
	      //c.setPath("/"); //cookie저장 경로 지정
	      //response(client 정보)
	      response.addCookie(c);
	      //f12 - application 'saveId' cookie 저장된것 확인
	    }
	    else {
	      //checkbox에 check가 안되어있으면 저장된 cookie를 지워서
	      //다음 페이지가 열릴때 반영되지 않게 설정
	      Cookie c = new Cookie("saveId", id);
	      c.setMaxAge(0); //기간이 존재하지 않으므로, 바로 생성과 동시에 삭제
	      response.addCookie(c);
	    }
	    

	    view = "/"; // 디폴트 "/" url은 index.jsp 연결~
	    response.sendRedirect(request.getContextPath() + view);
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
	    //데이터가 있으면 dispatcher로 전송 (에러로 넘어왔는지 또는 로그인 성공해서 넘어왔는지를)
	    RequestDispatcher rd = request.getRequestDispatcher(view);
	    rd.forward(request, response);
	  }
	  
	  //request 객체가 Member 오브젝트를 저장함(로그인 성공한 Member instance 또는 실패해서 null)
	  //request.setAttribute("loginMember", m);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
