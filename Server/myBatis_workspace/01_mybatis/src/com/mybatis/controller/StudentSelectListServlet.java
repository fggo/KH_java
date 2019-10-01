package com.mybatis.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mybatis.model.service.MybatisService;
import com.mybatis.model.service.MybatisServiceImpl;
import com.mybatis.model.vo.Student;
import com.mybatis.model.vo.Student2;

/**
 * Servlet implementation class StudentSelectListServlet
 */
@WebServlet("/selectList.do")
public class StudentSelectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//D.I 의존성 주입으로 spring에서는 자동으로 들어감
	private MybatisService service = new MybatisServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSelectListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  /* 기본vo객체이용해서 조회하기 */
	  List<Student> list = service.selectListStudent();

	  /* resultMap을 이용해서 리스트 조회하기 */
	  List<Student2> list2 = service.selectListStudent2();

	  /* map을 이용해서 vo없이 리스트 조회하기 */
	  List<Map> list3 = service.selectListMap();

	  request.setAttribute("list", list);
	  request.setAttribute("list2", list2);
	  request.setAttribute("list3", list3);
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
