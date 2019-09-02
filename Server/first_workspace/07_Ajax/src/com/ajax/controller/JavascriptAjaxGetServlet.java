package com.ajax.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JavascriptAjaxGetServlet
 */
@WebServlet("/js/test")
public class JavascriptAjaxGetServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public JavascriptAjaxGetServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));

    System.out.println("전달받은 값 : " + name + " " + age);

    request.getRequestDispatcher("/views/ajax/print.jsp").forward(request, response);

//	  서블릿 통신값을 확인하기 위해 출력: 페이지 url 바뀌지 않고 페이지 element 변경 됨
//	  response.setContentType("text/html; charset=UTF-8");
//	  PrintWriter out = response.getWriter();
//
//	  out.print("전송 잘받음 -서버가-");
//	  out.print("<ul>");
//	  out.print("<li>이름 : " + name + "</li>");
//	  out.print("<li>나이 : " + age + "</li>");
//	  out.print("</ul>");
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
   *      response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
