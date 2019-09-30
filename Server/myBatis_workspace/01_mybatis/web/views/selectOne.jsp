<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <!-- CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <!-- JS -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container card my-5 col-md-8 jumbotron" id="student-container">
    <h3>학생정보 검색</h3>
    <p>총학생수는 <c:out value="${count }"/>명 입니다.</p>
    <!-- <p>총학생수는 ${count }명 입니다.</p> -->
    <%-- <p>총학생수는 ${requestScope.count }명 입니다.</p> --%>
    <!-- 조회된 결과 출력 
    결과가 없으면 결과 테이블이 출력되지 않고,
    결과가 있으면 테이블 형식으로 출력 할 것 -->

    <c:if test='${not empty student}'>
      <table class="table table-sm" id="selectNoResult">
        <tr>
          <th>번호</th>
          <th>이름</th>
          <th>전화번호</th>
          <th>이메일</th>
          <th>주소</th>
          <th>둥록일</th>
        </tr>
        <%-- <c:forEach var="item" items="${student}" varStatus="i"> --%>
        <tr>
          <td><c:out value='${student["studentNo"]}'/></td>
          <td><c:out value='${student["studentName"]}'/></td>
          <td><c:out value='${student["studentTel"]}'/></td>
          <td><c:out value='${student["studentEmail"]}'/></td>
          <td><c:out value='${student["studentAddr"]}'/></td>
          <td><c:out value='${student["studentRegDate"]}'/></td>
        </tr>
        <%-- </c:forEach> --%>
        
      </table>
    </c:if>

  </div>
</body>
</html>