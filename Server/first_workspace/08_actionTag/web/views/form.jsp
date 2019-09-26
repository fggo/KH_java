<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <!-- CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
  <!-- JQUERY -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <!-- JAVASCRIPT -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
  
  <div class="container card my-5">
    <form action="useBeanTest.jsp" method="get" class="form">
      이름: <input type="text" name="name" class="form-control col-md-3" /><br>
      나이: <input type="number" name="age" class="form-control col-md-3"/><br>
      성별: <input type="text" name="gender" class="form-control col-md-3"/><br>
      <input type="submit" value="제출" class="form-control"/><br>
    </form>
  </div>

</body>
</html>