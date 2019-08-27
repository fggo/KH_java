package com.kh.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class AdminMemberSearchServlet
 */
@WebServlet("/admin/memberFinder")
public class AdminMemberSearchServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    String type=request.getParameter("searchType");
    String keyword=request.getParameter("searchKeyword");
    int cPage;
    try {
      cPage=Integer.parseInt(request.getParameter("cPage"));
    }catch(NumberFormatException e) {
      cPage=1;
    }
    int numPerPage=5;
    
    int totalData=new MemberService().selectCountMember(type,keyword);
    List<Member> list=new MemberService().selectMemberList(type,keyword,cPage,numPerPage);
    
    //전체page계산
    int totalPage=(int)Math.ceil((double)totalData/numPerPage);
    
    //pageBar구성
    int pageSizeBar=5;//페이지바크기(나오는 숫자갯수)
    String pageBar="";//전송할 코드(pageBar구성) 누적할 문자열
    int pageNo=((cPage-1)/pageSizeBar)*pageSizeBar+1;
    int pageEnd=pageNo+pageSizeBar-1;
    
    //출력코드 pageBar에 누적하기
    if(pageNo==1) {
      pageBar+="<span>[이전]</span>";
    }else {
      pageBar+="<a href='"+request.getContextPath()
      +"/admin/memberFinder?cPage="+(pageNo-1)
      +"&searchType="+type+"&searchKeyword="+keyword
      +"'>[이전]</a>";
    }
    while(!(pageNo>pageEnd||pageNo>totalPage)) {
      if(cPage==pageNo) {
        pageBar+="<span class='cPage'>"+pageNo+"</span>";
      }else {
        pageBar+="<a href='"+request.getContextPath()
        +"/admin/memberFinder?cPage="+(pageNo)
        +"&searchType="+type+"&searchKeyword="+keyword
        +"'>"+pageNo+"</a>";
      }
      pageNo++;
    }
    if(pageNo>totalPage) {
      pageBar+="<span>[다음]</span>";
    }else {
      pageBar+="<a href='"+request.getContextPath()
      +"/admin/memberFinder?cPage="+(pageNo)
      +"&searchType="+type+"&searchKeyword="+keyword
      +"'>[다음]</a>";
    }
    request.setAttribute("pageBar", pageBar);
    request.setAttribute("searchType", type);
    request.setAttribute("searchKeyword",keyword);
    request.setAttribute("cPage",cPage);
    request.setAttribute("members",list);
    request.getRequestDispatcher("/views/admin/memberList.jsp").forward(request, response);
  
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
