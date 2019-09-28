<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
 <h1>예외처리 c:catch</h1>
 
 <%
   String[] arr = null;
   request.setAttribute("arr", arr);
 %>
 
 <c:catch var="e">
   에러발생전<br/>
   <%=arr[0]%>
   에러발생후!<br/>
 </c:catch>
 <c:out value="${e}"/>
<br>   에러발생후!<br/>

</body>
</html>