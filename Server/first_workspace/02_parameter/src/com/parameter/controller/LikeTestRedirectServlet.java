package com.parameter.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LikeTestRedirectServlet
 */
@WebServlet("/likeredirect.do")
public class LikeTestRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeTestRedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 관련된것은 request dispatcher. page전환시 가지고 있는 data 전달
		//sendRedirect는 아님. 다시 browser에게 응답(response)
		//sendRedirect(맵핑주소)-> response 
//		response.sendRedirect("index.html");
		response.sendRedirect("likeview"); //null 값 name
//		response.sendRedirect("/likeview"); //ERROR!

//		@WebServlet('/likeview') ->response.sendRedirect("likeview");
//		ERROR!! HTTP status 500 
//		int age에 값이 들어가지 않음 (저장할 수 있는 scope 범위를 넘어서)
//		request -> server get메소드 끝나면 data 사라짐
//		redirect -> browser ->request 객체 새로 생성되어 들어오므로 int age 에 null값


//		likeredirect.do가 아니라 http://localhost:9090/02_secondWeb/index.html로 redirect됨
//		redirect는 데이터 전송 안됨. 데이터 전송 되지만 JSP로 이렇게 데이터 보낼수는 있음(하지만 server에서 만들어서 보낸 값)
//		response.sendRedirect("index.html?name=유병승"); 


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
