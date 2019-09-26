<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
   action.model.vo.Person p=new action.model.vo.Person("서현희",22,"여");
 %>
<%
  request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=request.getParameter("title") %></title>
  <!-- CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
  <!-- JQUERY -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <!-- JAVASCRIPT -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
  ul{
    list-style-type:none;
  }
  li{
    display:inline;
  }
</style>
</head>
<body>
  <header class="jumbotron">
    <div class="container card">
      <h3><%=request.getParameter("title") %></h3>
      <ul>
        <li>main</li>
        <li>notice</li>
        <li>board</li>
      </ul>
    </div>
  </header>