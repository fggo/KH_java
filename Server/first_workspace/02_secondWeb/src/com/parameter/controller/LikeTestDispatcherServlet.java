package com.parameter.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LikeTestDispatcherServlet
 */
@WebServlet("/likedispatcher.do")
public class LikeTestDispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeTestDispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String msg = "저희 " +name+ "님 홈페이지를 이용해주셔서 감사합니다. 생축!!!!!!!!!!";
//		request.setAttribute(key=String, value=Object);
//		-> 데이터를 request객체에 key/value방식으로 저장함
		request.setAttribute("msg", msg);
//		request 객체에 msg='저희 홈페이지...' 저장됨
//		다른서블릿이나 view화면으로 전환할때 requestDispatcher(전환될 서블릿 mapping주소, view 화면 이름)를 이용
		RequestDispatcher rd = request.getRequestDispatcher("likeview");

//		REDIRECT -> likeview
//		localhost:9090/02_secondWeb/index.html btn click ->
//		localhost:9090/02_secondWeb/testPerson2.html submit click ->
//		http://localhost:9090/02_secondWeb/likedispatcher.do
//		URL은 한개지만 servlet 2개가 사용되서 화면에 출력됨
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
