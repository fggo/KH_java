package com.ajax.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberSerachServlet
 */
@WebServlet("/ajax/autoComplete.do")
public class MemberSerachServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSerachServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //원래는 service + dao -> 만들어서 해야함
    // TODO Auto-generated method stub
    String key=request.getParameter("key");
    List<String> list=new ArrayList<String>();
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","web","web");
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select userName from member where userName like '%"+key+"%'");
        while(rs.next()) {
            list.add(rs.getString("userName"));
        }
    }catch(Exception e) {
        e.printStackTrace();
    }
    //1.list
//    request.setAttribute("list",list);
//    request.getRequestDispatcher("/views/jqueryAjax/list.jsp").forward(request,response);
    //2.csv
    String csv ="";
    if(!list.isEmpty()) {
      for(int i =0; i<list.size(); i++) {
        if(i!=0) csv+=",";
        csv += list.get(i);
      }
    }
    response.setContentType("text/csv; charset=UTF-8");
    response.getWriter().write(csv);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
