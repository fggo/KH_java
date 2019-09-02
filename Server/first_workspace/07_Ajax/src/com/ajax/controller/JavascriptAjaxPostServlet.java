package com.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JavascriptAjaxPostServlet
 */
@WebServlet("/js/test2")
public class JavascriptAjaxPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JavascriptAjaxPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //use filter instead!
	  request.setCharacterEncoding("UTF-8");

	  String name = request.getParameter("name");
	  int age = Integer.parseInt(request.getParameter("age"));
	  
	  System.out.println("name : " + name + " age : " + age);
	  response.setContentType("text/html; charset=UTF-8");
	  
	  PrintWriter out = response.getWriter();

	  out.print("<h1>name : " + name + "</h1>");
	  out.print("<h1>age : " + age + "</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
