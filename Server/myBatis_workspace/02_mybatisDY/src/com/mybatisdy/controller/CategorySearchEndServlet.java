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
 * Servlet implementation class CategorySearchEndServlet
 */
@WebServlet("/categorySearchEnd.do")
public class CategorySearchEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpService service = new EmpServiceImpl();
    /**
     * Default constructor. 
     */
    public CategorySearchEndServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("utf-8");

	  String type = request.getParameter("searchType");
	  String key = request.getParameter("keyword");

	  Map<String, String> param = new HashMap<String, String>();
	  param.put("type", type);
	  param.put("key", key);
	  
	  List<Map> list = service.selectSearch1(param);

	  request.setAttribute("list", list);
	  request.getRequestDispatcher("/WEB-INF/views/search1.jsp")
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
