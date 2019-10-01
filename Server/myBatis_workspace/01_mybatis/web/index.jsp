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
    
    <form action="${path }/paramMybatis" method="post" class="form form-inline">
      <label for="no">학생번호: </label>
      <input type="text" name="no" id="no" class="form-control" />
      <input type="submit" value="전송" class="btn btn-sm btn-outline-info" />
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

    <a href="${path }/selectList.do">리스트를 이용하여 다중행 출력</a>
    <a href="${path }/updateStudent.do">학생 업데이트/삭제</a>
    
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