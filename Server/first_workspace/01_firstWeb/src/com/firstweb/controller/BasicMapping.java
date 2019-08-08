package com.firstweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BasicMapping extends HttpServlet{

	private static final long serialVersionUID = 6059484008332878443L;

//	alt+s+v
//	req로 보내면 packet 정보를 request response로 나눔
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
//		[Mapping in web.xml] mappingCheck.do -> BasicMapping.java
//	    <servlet-class>com.firstweb.controller.BasicMapping</servlet-class>
//	    http://localhost:9090/Parking/mappingCheck.do
//		f12 network status code 200
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
}
