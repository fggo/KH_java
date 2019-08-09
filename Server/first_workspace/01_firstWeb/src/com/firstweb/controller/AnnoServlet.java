package com.firstweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// annotation is an Object
// annocation should not duplicate
@WebServlet("/anno.do")
public class AnnoServlet extends HttpServlet {
	private static final long serialVersionUID = 7568401931201069239L;
	
	public AnnoServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.write("<html>");
		out.write("<body>");
		out.write("<h1>어노테이션 연결방식으로 연결된 서블릿</h1>");
		out.write("</body>");
		out.write("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
