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
  <div class="text-left container col-md-10 py-3 my-1">
    <a href="${path }/index.jsp">index</a>
  </div>
  <div class="container card my-2 py-3 col-md-10 jumbotron">
    <div id="search-container">
      <form action="${path }/categorySearchEnd.do" method="post" class="form form-inline my-2">
        <select name="searchType" class="form-control mx-1" required >
          <option value='' disabled selected>검색타입</option>
          <option value="emp_id" <c:if test="${'emp_id' eq param.searchType }"> selected</c:if>>사번</option>
          <option value="emp_name" <c:if test="${'emp_name' eq param.searchType }"> selected</c:if>>사원명</option>
          <option value="email" <c:if test="${'email' eq param.searchType }"> selected</c:if>>이메일</option>
          <option value="phone" <c:if test="${'phone' eq param.searchType }"> selected</c:if>>전화번호</option>
        </select>
        <input type="search" name="keyword" class="form-control mx-1" required />
        <input type="submit" value="검색" class="form-control btn btn-sm btn-info" />
      </form>

      <c:if test="${not empty list}">

        <table class="table table-sm">
          <tr>
            <th>사번</th>
            <th>사원명</th>
            <th>주민번호</th>
            <th>이메일</th>
            <th>전화번호</th>
            <th>부서코드</th>
            <th>직급코드</th>
            <th>급여레벨</th>
            <th>급여</th>
            <th>보너스율</th>
            <th>매니져사번</th>
            <th>입사일</th>
          </tr>
          <c:forEach var="e" items="${list }">
            <tr>
              <td><c:out value="${e['EMP_ID']}" /></td>
              <td><c:out value="${e['EMP_NAME']}" /></td>
              <td><c:out value="${e['EMP_NO']}" /></td>
              <td><c:out value="${e['EMAIL']}" /></td>
              <td><c:out value="${e['PHONE']}" /></td>
              <td><c:out value="${e['DEPT_CODE']}" /></td>
              <td><c:out value="${e['JOB_CODE']}" /></td>
              <td><c:out value="${e['SAL_LEVEL']}" /></td>
              <td><fmt:formatNumber value="${e['SALARY']}" type="currency" /></td>
              <td><fmt:formatNumber value="${e['BONUS']}" type="percent" /></td>
              <td><c:out value="${e['MANAGER_ID']}" /></td>
              <td><fmt:formatDate value="${e['HIRE_DATE']}"
                                  type="date"
                                  pattern="yyyy-MM-dd" /></td>
            </tr>
          </c:forEach>
        </table>

      </c:if>
    </div>
  </div>
</body>
</html>