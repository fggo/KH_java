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
  <!-- jQuery -->
  <!-- JS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<!-- 
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
  <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script> -->

  <style>
    div#page-container{padding:15px;}
  </style>
</head>
<body>
  <div class="text-left container col-md-10 py-3 my-1">
    <a href="${path }/index.jsp">index</a>
  </div>
  <div class="container card mb-3 col-md-10 jumbotron">
    <div id="search-container">
      <c:if test="${not empty list }">
         <table class="table table-sm container">
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
            <th>성별</th>
         </tr>
            <c:forEach var="e" items="${list }">
            <tr>
               <td><c:out value="${e['EMP_ID'] }"/></td>
               <td><c:out value="${e['EMP_NAME'] }"/></td>
               <%-- <td><c:out value="${e['EMP_NO'] }"/></td> --%>
               <td><c:out value="${fn:substring(e['EMP_NO'],0,8).concat('*******') }"/></td>
               <td><c:out value="${e['EMAIL'] }"/></td>
               <td><c:out value="${e['PHONE'] }"/></td>
               <td><c:out value="${e['DEPT_CODE'] }"/></td>
               <td><c:out value="${e['JOB_CODE'] }"/></td>
               <td><c:out value="${e['SAL_LEVEL'] }"/></td>
               <%-- <td><c:out value="${e['SALARY'] }"/></td> --%>
               <td><fmt:formatNumber value="${e['SALARY'] }" type="currency"/></td>
               <%-- <td><c:out value="${e['BONUS'] }"/></td> --%>
               <td><fmt:formatNumber value="${e['BONUS'] }" type="percent"/></td>
               <td><c:out value="${e['MANAGER_ID'] }"/></td>
               <%-- <td><c:out value="${e['HIRE_DATE'] }"/></td> --%>
               <td><fmt:formatDate value="${e['HIRE_DATE'] }" type="date" pattern="yyyy/MM/dd"/></td>
               <%-- <td><c:out value="${e['GENDER'] }"/></td> --%>
               <td>
                  <c:set var="gender" value="${fn:substring(e['EMP_NO'],7,8)}" />
                  <c:choose>
                    <c:when test="${gender == '1' }">남</c:when>
                    <c:when test="${gender == '2' }">여</c:when>
                  </c:choose>
               </td>
            </tr>
            </c:forEach>
         </table>
      </c:if>
      <c:if test="${empty list }">
         <h3>검색결과가 없습니다!</h3>
      </c:if>
   </div>
   <div id="page-container">
      ${pageBar }
   </div>
  </div>
</body>
</html>