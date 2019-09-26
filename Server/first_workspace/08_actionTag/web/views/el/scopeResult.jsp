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

  <div class="container card my-3 col-md-6 py-3 px-3">
    <h2>공유객체에 있는 데이터 EL로 받아오기</h2>
    <p>${name }</p>
    <p>${age }</p>
    <p>${userId }</p>
    <p>${admin }</p>
    <hr>

    <h3>중복값출력하기</h3>
    <p>${item }</p>
    <p>${item} ${sessionScope.item }</p>
    <hr>

    <h3>객체 받기</h3>
    <p>${person.name eq "김태엽" }</p>
    <p>${person.age }</p>
    <p>${person.gender }</p>
    <hr>

    <h3>컬렉션 받아오기</h3>
    <p>${sports }</p>
    <p>${sports.get(0) }</p>
    <p>${persons }</p>
    <p>${persons.get(0).name }</p>
    <p>${persons.get(0).age }</p>
    <hr>
    
    <h3>header확인하기</h3>
    <p>${header }</p>
    <p>${header["referer"] }</p>
    <hr>
    
    <h3>cookie</h3>
    <p>${cookie }</p>
    <p>${cookie["JSESSIONID"].value }

  </div>
      
</body>
</html>