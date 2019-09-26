<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("utf-8");

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <!-- CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
  <!-- JQUERY -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <!-- JAVASCRIPT -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container card my-5 col-md-4 py-3 px-3">
    <h2>계산결과확인</h2>
    <h4>결과값 : <%=request.getAttribute("result") %></h4>
    <h4>시작값 : <%=request.getParameter("su1") %></h4>
    <h4>끝값 : <%=request.getParameter("su2") %></h4>
    <h4>추가값 : <%=request.getParameter("that") %></h4>
    <hr>
    <h2>EL로 불러오기!!</h2>
    <h4>결과값 : ${result }</h4>
    <h4>시작값 : ${param.su1 }</h4>
    <h4>끝값 : ${param.su2 }</h4>
    <h4>추가값 : ${param.that }</h4>
  </div>
</body>
</html>