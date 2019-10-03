package com.prac.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prac.model.service.EmpService;
import com.prac.model.service.EmpServiceImpl;

/**
 * Servlet implementation class EmpInsertEndServlet
 */
@WebServlet("/insertEmpEnd.do")
public class EmpInsertEndServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  private EmpService service = new EmpServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpInsertEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String no = request.getParameter("no");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String deptCode = request.getParameter("deptCode");
    String jobCode = request.getParameter("jobCode");
    String salLevel = ""; //S1 ~ S6
    int sal = Integer.parseInt(request.getParameter("sal"));
    switch(sal/1000000) {
      case 1: salLevel = "S1"; break;
      case 2: salLevel = "S2"; break;
      case 3: salLevel = "S3"; break;
      case 4: salLevel = "S4"; break;
      case 5: salLevel = "S5"; break;
      case 6:case 7:case 8:case 9: salLevel = "S6"; break;
    }
    salLevel = (sal >= 10000000)? "S6":salLevel;

    String temp = request.getParameter("bonus");
    double bonus = temp.equals("")? .0: Double.valueOf(request.getParameter("bonus"));
    String mgrId = request.getParameter("mgrId");
    Date hireDate = null;
    Date entDate = null;
    char entYn = 'N';
    
    Map<String, Object> param = new HashMap<String, Object>();
    param.put("id", id);
    param.put("name", name);
    param.put("no", no);
    param.put("email", email);
    param.put("phone", phone);
    param.put("deptCode", deptCode);
    param.put("jobCode", jobCode);
    param.put("salLevel", salLevel);
    param.put("sal", sal);
    param.put("bonus", bonus);
    param.put("mgrId", mgrId);
    param.put("hireDate", hireDate);
    param.put("entDate", entDate);
    param.put("entYn", entYn);

    int result = service.insertEmp(param);

    response.setContentType("text/html;charset=utf-8");
    response.getWriter().write(result>0? "Successful insert using ajax!" : "insert Failed using ajax.");
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
