package com.mybatisdy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatisdy.model.service.EmpService;
import com.mybatisdy.model.service.EmpServiceImpl;

/**
 * Servlet implementation class CategorySearchEnd2Servlet
 */
@WebServlet("/categorySearchEnd2.do")
public class CategorySearchEnd2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EmpService service = new EmpServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorySearchEnd2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("utf-8");

	  String type = request.getParameter("searchType");
	  String key = request.getParameter("keyword");
	  String gender = request.getParameter("gender");
	  int salary = 0;
    if (request.getParameter("salary") != null
        && !request.getParameter("salary").equals(""))
      salary = Integer.parseInt(request.getParameter("salary"));

	  String flag = request.getParameter("salary_le_ge");

	  String hireDate = request.getParameter("hire_date");
	  String hireFlag = request.getParameter("hire_le_ge");
	  
	  //다중값 받아서 조회하기
	  String[] jobs = request.getParameterValues("job_code");

	  Map<String, Object> param = new HashMap<String, Object>();
	  param.put("type", type);
	  param.put("key", key);
	  param.put("gender", gender);
	  param.put("salary", salary);
	  param.put("flag", flag);
	  param.put("hireDate", hireDate);
	  param.put("hireFlag", hireFlag);
	  param.put("jobs", jobs);

	  List<Map> list = service.selectSearch2(param);

	  request.setAttribute("list", list);
	  request.getRequestDispatcher("/WEB-INF/views/search2.jsp")
	    .forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
