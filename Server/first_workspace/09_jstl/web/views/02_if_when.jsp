<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
  <div class="container card my-5 jumbotron py-3 px-3 col-md-6">
    <h1>if문</h1><br/>
    <pre>
      c:if태그를 이용해서 사용, java에서 조건문을 사용한것과 동일
      속성 : test, var
      test : 조건문 java에서 if(요기), 리터럴 true, false | EL연산을 이용가능
      var : test에 들어가 있는 조건문의 결과를 저장하는 변수
    </pre><br/>
    <c:if test="${20<30}" var="result">
      <h3>이거 출력되니?</h3>
    </c:if>
    <c:out value="${result}"/>
    
    <h1>client에서 받은 값 기준으로 출력하기</h1>
    <%
      request.setCharacterEncoding("UTF-8");
      //String choice = request.getParameter("food");
      
    %>
    <%-- <%if(choice.equals("족발")){ %>
      <h4>족발</h4>
    <%} %> --%>

    <c:if test='${param.food == "족발"}'>
      <h4>족발랄</h4>
    </c:if>   
    <c:if test='${param.food == "곱창"}'>
      <h4>곱창</h4>
    </c:if>
    <c:if test='${param.food eq "연어회"}'>
      <h4>연어회</h4>
    </c:if>
    <c:if test='${!empty loginMember }'>
      
    </c:if>
    
    <h2>choose문</h2>
    <p>
      <pre>
        c:choose태그 사용하여 분기처리하는것
        java의 switch문이랑 동일, switch case
        switch(값){
          case 1:
        }
        c:when태그로분기
        사용법:
      </pre>

      <c:choose>
        <c:when test="${param.food == '족발'}">
          <h4>choose 족발</h4>
        </c:when>
        <c:when test="${param.food == '연어회'}">
          <h4>choose 연어</h4>
        </c:when>
        <c:otherwise>
          <h1>그건 처리옵션에없어</h1>
        </c:otherwise>
      </c:choose>

    </p>
  </div>

</body>
</html>