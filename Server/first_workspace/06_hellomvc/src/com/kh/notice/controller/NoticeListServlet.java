package com.kh.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeListServlet
 */
@WebServlet("/notice/noticeList")
public class NoticeListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    //비즈니스 로직
    //DB의 noticeTable에 있는 모든값을 받아오기!
    //자료가 여러개있을도 있음 -> paging 처리
    int cPage = 0;
    try {
      cPage = Integer.parseInt(request.getParameter("cPage"));
    } catch(NumberFormatException e) {
      cPage = 1;
    }
    
    int numPerPage = 10;
    int totalNotice = new NoticeService().selectCountNotice();
    List<Notice> list = new NoticeService().selectNoticeList(cPage, numPerPage);
    
    int totalPage = (int)Math.ceil((double)totalNotice/numPerPage);
    String pageBar = "";
    int pageBarSize = 5;
    int pageNo = ((cPage-1)/pageBarSize)*pageBarSize + 1;
    int pageEnd = pageNo + pageBarSize - 1;
    
    if(pageNo == 1) {
      pageBar += "<span>[이전]</span>";
    }
    else {
      pageBar += "<a href="+request.getContextPath()+"/notice/noticeList?cPage=" + (pageNo -1) + ">[이전]</a>";
    }
    while(!(pageNo >pageEnd || pageNo > totalPage)) {
      if(pageNo == cPage) {
        pageBar += "<span>" + pageNo+ "</span>";
      }
      else {
        pageBar += "<a href="+request.getContextPath()
                   +"/notice/noticeList?cPage=" + pageNo + "'>" +pageNo + "</a>";
      }
      pageNo++;
    }
    if(pageNo > totalPage) {
      pageBar += "<span>[다음]</span>";
    }
    else {
      pageBar += "<a href="+request.getContextPath()
               +"/notice/noticeList?cPage=" + (pageNo) + ">[다음]</a>";
    }
    request.setAttribute("pageBar", pageBar);
    request.setAttribute("cPage",  cPage);
    request.setAttribute("list", list);

    request.getRequestDispatcher("/views/notice/noticeList.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
