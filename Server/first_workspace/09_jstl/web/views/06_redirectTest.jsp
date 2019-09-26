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
  <%-- <c:url var="site" value="http://rclass.iptime.org:9999/"></c:url>
  <c:if test='${!empty param.url}'>
    <c:redirect url="http://rclass.iptime.org:9999/${param.url}" />
  </c:if> --%>
  
  <c:url var="site" value="http://rclass.iptime.org:9999/"></c:url>
  <c:if test='${!empty param.url}'>
    <c:redirect url="${site}${param.url}" />
  </c:if>
  
  <c:url var="naver" value="https://search.naver.com/search.naver">
    <c:param name="query" value="최장원"/>
  </c:url>
  <c:redirect url="${naver}">
    <%-- <c:param name="query" value="최장원"/> --%>
  </c:redirect>
  
</body>
</html>