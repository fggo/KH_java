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
  <div class="container card col-md-8 my-2 py-3 px-3 jumbotron">

    <a href="${path }/firstMybatis">첫 마이바티스활용</a>
    
    <form action="${path }/paramMybatis" method="post" >
      학생번호: <input type="text" name="no" />
      <input type="submit" value="전송" />
    </form>
  
    <a href="${path }/inputName">이름만 등록하기</a><br>
    <a href="${path }/inputStudentAll">학생 등록하기</a><br>
    <a href="${path }/selectCount">학생 수 조회</a><br>

    <form action="${path }/student/selectOne.do" name="frm" class="form form-inline">
      <table class="table table-sm">
        <tr>
          <td>
            <input type="number" name="no" class="form-control" />
            <input type="submit" value="조회" class="btn btn-sm btn-outline-info form-control" />
          </td>
        </tr>
      </table>
    </form>
  </div>

  <script>
    // $(function(){
    //   $.ajax({
    //     url: "${path }/student/selectOne.do",
    //     type: "POST",
    //     data: { "no": ",
    //     dataType: "JSON",
    //     success: function (data) {
    //     }
    //   });
  
    // });
  </script>

  
</body>
</html>