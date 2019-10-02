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
  <div class="container card my-5 col-md-11 jumbotron">
    <div id="search-container">

      <form action="${path }/categorySearchEnd2.do" method="post" class="form form-inline mb-2">
        <table class="table table-sm" id="tbl-search">
          <tr>
            <td colspan="2">
              <select name="searchType" class="form-control mx-1" >
                <option value='' disabled selected>검색타입</option>
                <option value="emp_id" <c:if test="${'emp_id' eq param.searchType }"> selected</c:if>>사번</option>
                <option value="emp_name" <c:if test="${'emp_name' eq param.searchType }"> selected</c:if>>사원명</option>
                <option value="email" <c:if test="${'email' eq param.searchType }"> selected</c:if>>이메일</option>
                <option value="phone" <c:if test="${'phone' eq param.searchType }"> selected</c:if>>전화번호</option>
              </select>
              <input type="search" name="keyword" class="form-control mx-1" />
              <input type="submit" value="검색" class="form-control btn btn-sm btn-info" />
            </td>
          </tr>
          <tr>
            <th>성별</th>
            <td class="form-inline">
              <input type="radio" name="gender" value="남" id="gender0" class="form-control" />
              <label for="gender0">남</label>
              <input type="radio" name="gender" value="여" id="gender1" class="form-control" />
              <label for="gender1">여</label>
            </td>
          </tr>
          <tr>
            <th>월급</th>
            <td class="form-row">
              <input type="number" name="salary" min="0" step="100000" class="form-control" />
              <label>
                <input type="radio" name="salary_le_ge" id="salary_ge" value="ge" class="form-control">이상
              </label>
              <label>
                <input type="radio" name="salary_le_ge" id="salary_le" value="le" class="form-control">이하
              </label>
            </td>
          </tr>
          <tr>
            <th>입사일</th>
            <td class="form-row">
              <input type="date" name="hire_date" class="form-control" />
              <label>
                <input type="radio" name="hire_le_ge" id="hire_ge" value="ge" class="form-control">이상
              </label>
              <label>
                <input type="radio" name="hire_le_ge" id="hire_le" value="le" class="form-control">이하
              </label>
            </td>
          </tr>
          <tr>
            <th>직책</th>
            <td class="form-inline">
              <input type="checkbox" name="job_code" id="J1" value="J1" class="form-control" />
              <label for="J1">대표</label>
              <input type="checkbox" name="job_code" id="J2" value="J2" class="form-control" />
              <label for="J2">부사장</label>
              <input type="checkbox" name="job_code" id="J3" value="J3" class="form-control" />
              <label for="J3">부장</label>
              <input type="checkbox" name="job_code" id="J4" value="J4" class="form-control" />
              <label for="J4">차장</label>
              <input type="checkbox" name="job_code" id="J5" value="J5" class="form-control" />
              <label for="J5">과장</label>
              <input type="checkbox" name="job_code" id="J6" value="J6" class="form-control" />
              <label for="J6">대리</label>
              <input type="checkbox" name="job_code" id="J7" value="J7" class="form-control" />
              <label for="J7">사원</label>
            </td>
         </tr>
        </table>
      </form>

    </div>
    <c:if test="${not empty list}">

      <table class="table table-sm">
        <tr>
          <th>NO.</th>
          <th>Name</th>
          <th>ID</th>
          <th>Email</th>
          <th>TEL.</th>
          <th>부서코드</th>
          <th>직급코드</th>
          <th>급여레벨</th>
          <th>급여</th>
          <th>BONUS</th>
          <th>MGR</th>
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
</body>
</html>