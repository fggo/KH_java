<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <h2>forTokens태그 활용</h2>
    <pre>
      자바에서 tokenizer와 비슷한 기능을 하는 태그
      속성 : forEach와 비슷 var, items, delims
    </pre>

    <%
      String de = "젤라또,케익,마카롱,젤리,아이스";
      String language="자바.c,html.css,오라클.jsp,spring";
      request.setAttribute("de", de);
      request.setAttribute("language", language);
    %>
    <c:forTokens var = "d" items="${de}" delims=",">
      <c:if test="${d == '아이스'}">
        <%--<p>${d}</p>--%>
        <c:out value="${d}"/>
        <c:out value="존나차가움"/>
      </c:if>
    </c:forTokens><br>

    <c:forTokens var="lang" items="${language}" delims=",.">
      <%-- <c:out value='${lang}'/> --%>
      <c:out value='${lang}'/>
      <%--<p>${lang}</p>--%>
    </c:forTokens>
    
  </div>

</body>
</html>