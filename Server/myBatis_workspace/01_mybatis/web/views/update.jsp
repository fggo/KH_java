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
  <div class="container card my-5 col-md-8 jumbotron">
    <label for="stuNumber" class="form-inline">번호</label>
    <input type="number" id="stuNumber" name="stuNumber" class="form-control">

    <label for="stuName" class="form-inline">이름</label>
    <input type="text" id="stuName" name="stuName" class="form-control">

    <label for="stuEmail" class="form-inline">이메일</label>
    <input type="text" id="stuEmail" name="stuEmail" class="form-control">

    <!-- <input type="text" id="stuAddr" name="stuAddr"> -->
    <div class="container">
      <button id="updateBtn" class="btn btn-sm btn-outline-info">학생수정</button>
      <button id="deleteBtn" class="btn btn-sm btn-outline-danger">학생삭제</button>
    </div>
  </div>

  <script>
    $(function(){
      $('#updateBtn').click(function(){
        var no = $('#stuNumber').val();
        var name = $('#stuName').val();
        var email = $('#stuEmail').val();

        $.ajax({
          url: "${path }/updateEnd.do",
          data: {"no":no, "name":name, "email":email },
          // dataType: "JSON",
          success: function(data){
            alert(data);
          },
        });
      });

      $('#deleteBtn').click(function(){
        $.ajax({
          url: "${path }/delete.do",
          data: {"no": $("#stuNumber").val().trim() },
          success: function(data){
            alert(data);
          },
        });
      });
    });
  </script>
</body>
</html>