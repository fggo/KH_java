package com.ajax.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.model.vo.Member;

/**
 * Servlet implementation class JqueryAjaxCsvServlet
 */
@WebServlet("/test3.do")
public class JqueryAjaxCsvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqueryAjaxCsvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      List<Member> list = new ArrayList<Member>();

      list.add(new Member("박보검", "01045631234", "parkBogum.jpg"));
      list.add(new Member("쥴리아로버츠", "01012341234", "juliaRoberts.jpg"));
      list.add(new Member("맷데이먼", "0101100000", "mattDamon.jpg"));
      
      String csv = "";
      for(int i =0; i<list.size(); i++) {
        if(i != 0) csv += "\n";
        csv += list.get(i);
        //toString() 호출하여 ,로 구분된 자료 출력
      }
      System.out.println(csv);
    
      //csv방식으로 자료 viewe단으로 넘기기
      response.setContentType("text/csv;charset=UTF-8");
      response.getWriter().print(csv); //JSON도 비슷하게 데이터 보냄
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
