package com.parameter.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShareDataSendServlet
 */
// annotation내에서 request에 init parameter를 정의할 수 있음:
@WebServlet(name="ShareData", urlPatterns = "/shareSend",
            initParams = {
                @WebInitParam(name="dir",
                    value="C:\\Users\\user1\\KH\\KH_java\\Server\\first_workspace\\02_parameter\\web")
            }
  )
public class ShareDataSendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareDataSendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //-1- redirect (from ShareDataServlet)하면  
	    //request는 소멸되지만, server가 연결되어 있으면, context session 객체는 살아있음
		//sendRedirect()할때, request 객체가 새로 생성되고, 기존 request는 없어짐 (null)
		//context 및 session 객체에 있는 데이터 확인
		//단, redirect call한 servlet에서 session.invalidate(); 하면 session == null
		ServletContext context = getServletContext();
		HttpSession session = request.getSession();
		
		//contextData, sessionData, requestData 객체들의 attribute는 
		//ShareDataServlet에서 사용자 입력값(contextVal, sessionVal, requestVal)으로 set 함
		System.out.println("contextData : " + context.getAttribute("contextData"));
		System.out.println("sessionData : " + session.getAttribute("sessionData"));
		System.out.println("requestData : " + request.getAttribute("requestData"));

		//-2- dispatcher로 하면 request, response객체전부를 넘기므로, 지정한 모든 parameter값들이 담김
		System.out.println("===== paramData =====");
		System.out.println("requestParam : " + request.getParameter("contextVal"));
		System.out.println("requestParam : " + request.getParameter("sessionVal"));
		System.out.println("requestParam : " + request.getParameter("requestVal"));
		System.out.println("=====================");

		//context param
		//서블릿 initParam과 web.xml에서 정의한 context-param 값 확인하기
		String param = getInitParameter("dir");
		System.out.println("initParam : " + param);
		System.out.println("contextParam : " + context.getInitParameter("admin"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
