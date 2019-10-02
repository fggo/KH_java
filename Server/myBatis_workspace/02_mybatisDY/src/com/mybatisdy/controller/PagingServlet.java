package com.mybatisdy.controller;

import java.io.IOException;
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
 * Servlet implementation class PagingServlet
 */
@WebServlet("/paging.do")
public class PagingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmpService service = new EmpServiceImpl();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int cPage;
	  int numPerPage = 5;

	  try {
	    cPage = Integer.parseInt(request.getParameter("cPage"));
	  } catch(NumberFormatException e) {
	    cPage = 1;
	  }
	  
	  //rowbounds로 여러개 parameters 받을수 있음 selectList로
	  List<Map<String, String>> list = service.selectEmpList(cPage, numPerPage);

	  System.out.println(list);
	  System.out.println(list.size());

	  int totalCount = service.selectEmpCount();

	  int pageCount = (int)Math.ceil((double)totalCount/numPerPage);
	  int pageBarSize = 5;
	  String pageBar = "";
	  int pageNo = ((cPage-1)/pageBarSize)* pageBarSize + 1;
	  int pageEnd = pageNo + pageBarSize - 1;

	  pageBar += "<ul class='pagination "
            + "justify-content-center pagination-sm'>";
	   if(pageNo==1) {
	     pageBar+="<li class='page-item disabled'>";
	     pageBar+="<a class='page-link' href='#' tabindex='-1'>Next</a>";
	     pageBar+="</li>";
	   }else {
	     pageBar+="<li class='page-item'>";
	     pageBar+="<a class='page-link' href='javascript:void(0);' "
	         + "onclick='fn_paging("+(pageNo-1)+");'>Prev</a>";
	     pageBar+="</li>";
	   }
	   while(!(pageNo>pageEnd || pageNo>pageCount)) {
	      if(cPage == pageNo) {
	        pageBar+="<li class='page-item active'>";
	        pageBar+="<a class='page-link'>"+pageNo+"</a>";
	        pageBar+="</li>";
	      }else {
	        pageBar+="<li class='page-item'>";
	        pageBar+="<a class='page-link' href='javascript:void(0);' "
	            + "onclick='fn_paging("+(pageNo)+");'>"+pageNo+"</a>";
	        pageBar+="</li>";
	      }
	      pageNo++;
	    }
	    if(pageNo>pageCount) {
	      pageBar+="<li class='page-item disabled'>";
	      pageBar+="<a class='page-link'>Next</a>";
	      pageBar+="</li>";
	    }else {
	      pageBar+="<li class='page-item'>";
	      pageBar+="<a class='page-link' href='javascript:void(0);' "
	          + "onclick='fn_paging("+(pageNo)+");'>"+pageNo+"</a>";
	      pageBar+="</li>";
	    }
	    pageBar+="</ul>";
	    pageBar+="<script>";
	    pageBar+="function fn_paging(cPage){";
	    pageBar+="location.href='"+request.getRequestURI()+"?cPage='+cPage";
	    pageBar+="}";
	    pageBar+="</script>";
	    request.setAttribute("list", list);
	    request.setAttribute("pageBar", pageBar);
	    request.getRequestDispatcher("/WEB-INF/views/paging.jsp")
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
