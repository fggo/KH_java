package com.firstweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//서블릿 클래스가 되려면 HttpServlet클래스를 상속 받아야 함
public class BasicMapping extends HttpServlet{

	private static final long serialVersionUID = 6059484008332878443L;

//	alt+s+v
//	req로 보내면 packet 정보를 request response로 나눔
//  httprequest -> (request/response 로 나눔)
//	html form key/value 값이 request에 담김
//	getParameter(key=name 태그)
//	checkBox 배열로 보내짐 getParameterValues()
//	view로 다시 넘길때 request에 전달하려는 값을 object에 넣어서 넘김 setAttribte /getAttribute

//	e.g. 멤버데이터 조회시 string으로 db 조회 jdbc 데이터 
//	-> Object에 담아서 setAttribute -> request다시 view로 넘김 -> jsp로 for문으로 display

	public BasicMapping() {
		// TODO Auto-generated constructor stub
		super();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 데이터에 대해 인코딩 처리함
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// client와 연결되는 stream을 open
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html; charset: UTF-8");
		out.write("<html>");
		out.write("<body>");
		out.write("<h1>내가 처음으로 만든 servlet이야 <br>web.xml로 매핑되어있지</h1>");
		out.write("</body>");
		out.write("</html>");

		/* Mapping in web.xml : 
		 * <servlet>
		 *   <servlet-name>firstServlet</servlet-name>
		 *   <servlet-class>com.firstweb.controller.BasicMapping</servlet-class>
		 * </servlet>
		 * <servlet-mapping>
		 *   <servlet-name>firstServlet</servlet-name>
		 *   <url-pattern>/mappingCheck.do</url-pattern>
		 * </servlet-mapping>
		 * 'mappingCheck.do' maps to 'BasicMapping.java'
	     * http://localhost:9090/Parking/mappingCheck.do
		 * f12 network status code 200
		 * */
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
