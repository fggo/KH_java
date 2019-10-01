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

/**
 * Servlet implementation class UpdateEndServlet
 */
@WebServlet("/updateEnd.do")
public class UpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MybatisService service = new MybatisServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int no = Integer.parseInt(request.getParameter("no"));
	  String name = request.getParameter("name");
	  String email = request.getParameter("email");

	  Map<String, Object> param = new HashMap<String, Object>();
	  param.put("no", no);
	  param.put("name", name);
	  param.put("email", email);
	  
	  int result = service.updateStudent(param);
	  String msg = result>0? "수정성공":"수정실패";

	  response.setContentType("application/json;charset=utf-8");
	  response.getWriter().write(msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
