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
  <div class="container card my-2 col-md-10" id="insertContainer">
    <form action="${path }/insertEmpEnd.do" class="form form-inline">
      <label for="empId" class="form-control">Emp ID</label>
      <input type="number" class="form-control" id="empId">
      <label for="empName" class="form-control">Name</label>
      <input type="text" class="form-control" id="empName">
      <label for="empEmail" class="form-control">Email</label>
      <input type="text" class="form-control" id="empEmail">
      <label for="empPhone" class="form-control">Phone</label>
      <input type="text" class="form-control" id="empPhone">
      <label for="empEmail" class="form-control">Email</label>
      <input type="text" class="form-control" id="empEmail">
      <label for="empEmail" class="form-control">Email</label>
      <input type="text" class="form-control" id="empEmail">
    </form>
  </div>
</body>
</html>