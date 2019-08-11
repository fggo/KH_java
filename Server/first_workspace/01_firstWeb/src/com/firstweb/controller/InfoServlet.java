package com.firstweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* --PRAC--
url: info.do
infoServlet.java
return view:
 안녕하세요 저는 000입니다.
 * */
public class InfoServlet extends HttpServlet{
	
//	public InfoServlet() {
//		super();
//	}
//	req로 보내면 packet 정보를 request response로 나눔

	private static final long serialVersionUID = 8872560565864024514L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		resp.setContentType("text/html;charset=UTF-8;");
		PrintWriter out=resp.getWriter();
		out.write("<html>");
		out.write("<body>");
		out.write("<script>");
		out.write("alert('안녕 나는 스크립트);'");		
		out.write("</script>");
		out.write("<h1>안녕하세요 제 이름은 'baba' 입니다.</h1>");
		out.write("<body>");
		out.write("</html>");	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


}
