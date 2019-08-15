<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %>
<%
  ArrayList<String> list = new ArrayList<String>();
  list.add("유병승");
  list.add("권무관");
  list.add("김기호");
  list.add("여동규");
  list.add("서현희");
  list.add("류별리");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	 ul{
	   list-style: none;
	 }
	 li{
	   display: inline-block;
	   font-size: 20px;
	   font-weight: bolder;
	   margin-right: 5px;
	 }
	</style>
</head>
<body>
  <header>
    <ul>
      <li>
				<a href="<%=request.getContextPath() %>/views/mainView.jsp">메인화면</a>
      </li>
      <li>
				<a href="<%=request.getContextPath() %>/views/board.jsp">게시판</a>
      </li>
    </ul>
  </header>