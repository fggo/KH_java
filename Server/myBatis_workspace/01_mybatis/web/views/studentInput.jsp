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
  <div class="container card my-5 col-md-6 jumbotron">
    <form action="${pageContext.request.contextPath}/inputStudentEnd.do" method="post">
      <table id="tbl-student">
        <tr>
          <th>학생이름</th>
          <td>
            <input type="text" name="studentName" required/>
          </td>
        </tr>
        <tr>
          <th>전화번호</th>
          <td>
            <input type="tel" name="studentTel" maxlength="11" required/>
          </td>
        </tr>
        <tr>
          <th>이메일</th>
          <td>
            <input type="email" name="studentEmail"/> 
          </td>
        </tr>
        <tr>
          <th>주소</th>
          <td>
            <input type="text" name="studentAddr"/>
          </td>
        </tr>    
        <tr>
          <td colspan="2">
            <input type="submit" value="등록" />
          </td>
        </tr>
      </table>
    </form>


  </div>
</body>
</html>