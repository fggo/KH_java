<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<%@ page import ="com.jsp.model.service.MemberService, com.jsp.model.vo.Member" %>

<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	/* 비즈니스 로직 구성 */
	MemberService service = new MemberService();

	Member m = service.selectId(id, pw);
	request.setAttribute("member", m);

	if(m != null){
	  RequestDispatcher rd = request.getRequestDispatcher("loginView.jsp");
	  response.addHeader("location", "../common/header3.jsp");
	  rd.forward(request, response);
	} else{
	  request.setAttribute("path", "/views/member/loginView.jsp");
	  request.setAttribute("msg", "아이디 혹은 비밀번호가 다릅니다.");
	  RequestDispatcher rd = request.getRequestDispatcher("../common/msg.jsp");
	  rd.forward(request, response);
	}
%>