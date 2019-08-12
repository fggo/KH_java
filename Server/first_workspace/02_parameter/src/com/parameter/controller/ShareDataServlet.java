package com.parameter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShareDataServlet
 */
@WebServlet("/sharedata")
public class ShareDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareDataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		servelet추가 됐으니 server restart!
//		shareData.html에서 사용자가 input에 입력한 값을 받아서 출력
//		request객체<input type="text" name="requestVal"><br>
		String contextData = request.getParameter("contextVal");
		String sessionData = request.getParameter("sessionVal");
		String requestData = request.getParameter("requestVal");
		System.out.println("contextData : " + contextData);
		System.out.println("sessionData : " + sessionData);
		System.out.println("requestData : " + requestData);
		
		//1. context객체에 데이터 넣기
		//context객체를 불러오기 & 불러온객체에 데이터 넣기 setAttribute(key, value);
		ServletContext context = getServletContext();
		context.setAttribute("contextData", contextData);
		//web.xml에서 지정해준 init-param을 출력
		System.out.println("contextParam : " + context.getInitParameter("admin"));
		
		//2. session객체에 데이터 넣기
		//session객체 불러오기
		HttpSession session = request.getSession();
		//불러온 객체(session)에 데이터 넣기
		session.setAttribute("sessionData", sessionData);
		
		//3. request객체에 attribute지정.
		//requestData는 request로 이미 param으로 받음.
		//parameter variable request에도 attribute 지정 가능
		request.setAttribute("requestData", requestData);
		
		System.out.println("context : " + context.getAttribute("contextData"));
		System.out.println("session : " + session.getAttribute("sessionData"));
		System.out.println("request : " + request.getAttribute("requestData"));
		
		//로그아웃할때 session.invalidate() 사용
		//session.invalidate();
		//session객체 삭제! 삭제안하면 redirect해도 session 살아있음
		//server restart 한다음에 http://localhost:9090/02_parameter/shareSend 주소 입력시, 

		//context, session, request 모두 null
		//다른 페이지 넘어가도 login 유지 되는 이유:
		//session invalidate()는 logout 할때만 call 되므로
		//login 상태(session) 다른 페이지 에서도 유지됨


//		-1- redirect : request 소멸됨
//		response.sendRedirect("shareSend");

//		-2- dispatcher : request 살아있음.
//		기존 request를 parameter로 넘기기 때문.
//		ShareDataSendServlet 내에서 dispatcher로 request에 담긴 parameter 값 전부 가져올 수 있음!
		RequestDispatcher rd = request.getRequestDispatcher("shareSend");
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
