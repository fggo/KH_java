<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/views/error.jsp" %>
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- web.xml에 모든 exception에 대한 공통 에러페이지 등록가능 -->
  <h1>에러페이지!</h1>
  <%
    String[] foods = null;
  %>
  <h3><%=foods[0] %></h3> <!-- 500 Error -->

</body>
</html>