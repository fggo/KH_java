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
	
	//D.I ������ �������� spring������ �ڵ����� ��
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
	  /* �⺻vo��ü�̿��ؼ� ��ȸ�ϱ� */
	  List<Student> list = service.selectListStudent();

	  /* resultMap�� �̿��ؼ� ����Ʈ ��ȸ�ϱ� */
	  List<Student2> list2 = service.selectListStudent2();

	  /* map�� �̿��ؼ� vo���� ����Ʈ ��ȸ�ϱ� */
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
