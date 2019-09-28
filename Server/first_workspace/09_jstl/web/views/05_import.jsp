<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <!-- CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
  <!-- JQUERY -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <!-- JAVASCRIPT -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>

  <div class="container card my-5 jumbotron py-3 px-3 col-md-8">
    <h2>import태그 사용하기</h2>
    <pre>
      현재페이지에 다른 페이지 넣는것
      jsp:include 코드가 작성된 곳에 바로 출력
      변수에 삽입될 페이지를 저장함.
      EL로 출력문을 작성했을때 그 위치에서 출력

      c:import태그
      속성: url, var
      url -> 불러올페이지 경로(로컬에 있는 페이지 또는 web url 페이지 )
      var -> 저장 변수
      파라미터값을 보낼수 있음
    </pre>

    <jsp:include page="02_if_when.jsp">
      <jsp:param value="책정보" name="title"/>
    </jsp:include>
    
    <c:import var="p" url="01_set_out.jsp"/>
    <h2>넌왜안나와</h2> ${p}

    <c:import var="p2" url="testPage.jsp">
      <c:param name="title" value="첫번째"/>
    </c:import>
    ${p2}
    ${p2}
    ${p2}
    <div>
      <table border="1">
        <tr>
          <td>${p2}</td>
        </tr>
        <tr>
          <td>하하하하하하</td>
        </tr>
      
      </table>
    </div>

    <c:import var="p3" url="https://www.naver.com">
      <c:param name="title" value="첫번째"/>
    </c:import>
    <div class="container card">${p3}</div>
  
  </div>

</body>
</html>