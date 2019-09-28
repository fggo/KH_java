<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <!-- CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
  <!-- JQUERY -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <!-- JAVASCRIPT -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
  <div class="container card my-5 jumbotron py-3 px-3 col-md-6">
    <%-- <c:url var="site" value="http://rclass.iptime.org:9999/"></c:url>
    <c:if test='${!empty param.url}'>
      <c:redirect url="http://rclass.iptime.org:9999/${param.url}" />
    </c:if> --%>
    
    <c:url var="site" value="http://rclass.iptime.org:9999/"></c:url>
    <c:if test='${!empty param.url}'>
      <c:redirect url="${site}${param.url}" />
    </c:if>
    
    <c:url var="naver" value="https://search.naver.com/search.naver">
      <%-- <c:param name="query" value="댕댕이"/> --%>
    </c:url>

    <c:redirect url="${naver}">
      <c:param name="query" value="댕댕이"/>
    </c:redirect>
  </div>
  
</body>
</html>