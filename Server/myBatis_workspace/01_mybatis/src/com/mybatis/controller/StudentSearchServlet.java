package com.mybatis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MybatisService;
import com.mybatis.model.service.MybatisServiceImpl;

/**
 * Servlet implementation class StudentSearchServlet
 */
@WebServlet("/searchListName.do")
public class StudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MybatisService service = new MybatisServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("utf-8");

	  String key = request.getParameter("key");
	  String email = request.getParameter("email");

	  Map<String, String> params = new HashMap<String, String>();
	  params.put("name", key);
	  params.put("email", email);

//	  List<Map> list = service.selectSearchName(key);
	  List<Map> list2 = service.selectSearchMulti(params);

	  request.setAttribute("list3", list2);
	  request.getRequestDispatcher("/views/listView.jsp")
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
