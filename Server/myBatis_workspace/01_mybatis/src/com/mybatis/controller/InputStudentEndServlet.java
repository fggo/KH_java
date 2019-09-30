package com.mybatis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MybatisService;
import com.mybatis.model.service.MybatisServiceImpl;
import com.mybatis.model.vo.Student;

/**
 * Servlet implementation class InputStudentEndServlet
 */
@WebServlet("/inputStudentEnd.do")
public class InputStudentEndServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  private MybatisService service = new MybatisServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputStudentEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("studentName");
    String tel = request.getParameter("studentTel");
    String email = request.getParameter("studentEmail");
    String addr = request.getParameter("studentAddr");
    

    //1. vo를 이용해서 insert하기
//    Student s = new Student(name, tel, email, addr);
    //2. map을 이용해서 vo객체없이 insert하기
    Map<String, String> s = new HashMap<String, String>();
    s.put("name", name);
    s.put("tel", tel);
    s.put("email", email);
    s.put("addr", addr);

    int result = service.insertStudentAll(s);
    
    response.setContentType("text/html;charset=utf-8");
    response.getWriter().write(result>0? "입력완료" : "입력실패");
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
