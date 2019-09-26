<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>forTokens태그 활용</h1>
  <h2>
    자바에서 tokenizer와 비슷한 기능을 하는 태그
    속성 : forEach와 비슷 var, items, delims
  </h2>
  <%
    String de = "젤라또,케익,마카롱,젤리,아이스";
    String language="자바.c,html.css,오라클.jsp,spring";
    request.setAttribute("de", de);
    request.setAttribute("lang", language);
  %>
  <c:forTokens var = "d" items="${de}" delims=",">
    <c:if test="${d == '아이스'}">
      <p>${d}</p>
      <c:out value="존나차가움"/>
    </c:if>
    
  </c:forTokens>
  <c:forTokens var="lang" items="${lang}" delims=",.">
    <%-- <c:out value='${lang}'/> --%>
    <p>${lang}</p>
  </c:forTokens>
  

</body>
</html>