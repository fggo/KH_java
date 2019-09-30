package com.mybatis.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MybatisService;
import com.mybatis.model.service.MybatisServiceImpl;
import com.mybatis.model.vo.Student2;

/**
 * Servlet implementation class StudentSelectOneServlet
 */
@WebServlet("/student/selectOne.do")
public class StudentSelectOneServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  private MybatisService service = new MybatisServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int no = Integer.parseInt(request.getParameter("no"));
    Student2 s = service.selectOne(no);
    int count = service.selectCount();
    request.setAttribute("count", count);
    request.setAttribute("student", s);
    request.getRequestDispatcher("/views/selectOne.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
