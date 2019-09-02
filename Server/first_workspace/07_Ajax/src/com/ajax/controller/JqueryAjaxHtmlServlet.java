package com.ajax.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.model.vo.Member;

/**
 * Servlet implementation class JqueryAjaxHtmlServlet
 */
@WebServlet("/ajax/test.do")
public class JqueryAjaxHtmlServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqueryAjaxHtmlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Member> list = new ArrayList<Member>();

    list.add(new Member("박보검", "01045631234", "parkBogum.jpg"));
    list.add(new Member("쥴리아로버츠", "01012341234", "juliaRoberts.jpg"));
    list.add(new Member("맷데이먼", "0101100000", "mattDamon.jpg"));

    request.setAttribute("list", list);
    request.getRequestDispatcher("/views/jqueryAjax/sample.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
