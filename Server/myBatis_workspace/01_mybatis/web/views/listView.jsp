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
  <div class="container col-md-11 mt-3">
    <form action="${path }/searchListName.do" class="form form-inline">
      <label for="key">이름</label>
      <input name="key" type="text" class="form-control mx-2">
      <label for="email">이메일</label>
      <input name="email" type="text" class="form-control mx-2">

      <input type="submit" value="조회" class="btn btn-sm btn-info">
    </form>

  </div>
  <div class="container card my-5 col-md-11 border-info mt-0">
    <h3>학생 리스트 출력</h3>
    <table class="table table-sm">
      <tr>
        <th>학생번호</th>
        <th>이름</th>
        <th>전화번호</th>
        <th>이메일</th>
        <th>주소</th>
        <th>등록일</th>
      </tr>
      <c:forEach var="s" items="${list }">
        <tr>
          <td><c:out value="${s.student_no}" /></td>
          <td><c:out value="${s.student_name}" /></td>
          <td><c:out value="${s.student_tel}" /></td>
          <td><c:out value="${s.student_email}" /></td>
          <td><c:out value="${s.student_addr}" /></td>
          <td><fmt:formatDate dateStyle="full" value="${s.reg_date}" /></td>
        </tr>
      </c:forEach>
    </table>

    <h3>학생 리스트 출력(resultMap 이용)</h3>
    <table class="table table-sm">
      <tr>
        <th>학생번호</th>
        <th>이름</th>
        <th>전화번호</th>
        <th>이메일</th>
        <th>주소</th>
        <th>등록일</th>
      </tr>
      <c:forEach var="s" items="${list2 }">
        <tr>
          <td><c:out value="${s.studentNo}" /></td>
          <td><c:out value="${s.studentName}" /></td>
          <td><c:out value="${s.studentTel}" /></td>
          <td><c:out value="${s.studentEmail}" /></td>
          <td><c:out value="${s.studentAddr}" /></td>
          <td><fmt:formatDate dateStyle="long" value="${s.studentRegDate}" /></td>
        </tr>
      </c:forEach>
    </table>

    <h3>학생 리스트 출력(map 이용)</h3>
    <table class="table table-sm">
      <tr>
        <th>학생번호</th>
        <th>이름</th>
        <th>전화번호</th>
        <th>이메일</th>
        <th>주소</th>
        <th>등록일</th>
      </tr>
      <c:forEach var="s" items="${list3 }">
        <tr>
          <td><c:out value="${s['STUDENT_NO']}" /></td>
          <td><c:out value="${s['STUDENT_NAME']}" /></td>
          <td><c:out value="${s['STUDENT_TEL']}" /></td>
          <td><c:out value="${s['STUDENT_EMAIL']}" /></td>
          <td><c:out value="${s['STUDENT_ADDR']}" /></td>
          <td><fmt:formatDate dateStyle="short" value="${s['REG_DATE']}" /></td>
        </tr>
      </c:forEach>
    </table>
  </div>
</body>
</html>