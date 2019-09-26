<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forward Test</title>
  <!-- CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
  <!-- JQUERY -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <!-- JAVASCRIPT -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container my-5 card  col-md-4">

    <form action="calc.jsp" method="get" class="form py-3">
      첫번째 수 : <input type="number" name="su1" class="form-control col-md-4" />
      두번째 수 : <input type="number" name="su2" class="form-control col-md-4" /><br/>
      <input type="submit" value="계산하기!" class="btn btn-sm btn-outline-info" />
    </form>

  </div>
</body>
</html>