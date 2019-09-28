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

  <div class="container card my-3 px-3 py-3 col-md-6 jumbotron">

    <span>
      <a href="${path }/firstMybatis">마이바티스 활용 : 첫 INSERT</a>
    </span>

    <form action="${path}/paramMybatis" method="post" class="form form-inline" >
      <label for="no" class="input-group-prepend mx-2">학생번호 : </label>
      <input type="text" id="no" name="no" class="form-control my-2 mx-2" />
      <input type="submit" value="전송" class="form-control btn btn-sm btn-outline-info input-group-append" />
    </form>

  </div>

</body>
</html>