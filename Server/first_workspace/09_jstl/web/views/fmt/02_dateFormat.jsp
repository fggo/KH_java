<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
  <!-- CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <!-- JS -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <title>날짜 표현식</title>
</head>
<body>
  <div class="container jumbotron card col-md-6 my-3 px-3 py-3">
    <h3>기본날짜표현</h3>
    <p>
      <c:set var="now" value="<%=new java.util.Date() %>" />
    </p>
    <p>날짜표현은 fmt:formatDate태그를 이용함</p>
    <p>기본출력: <c:out value="${now}"/> </p>

    <p>formatDate적용(default) : <fmt:formatDate value="${now}" /></p>

    <h5>type속성을 통해 출력되는 날짜방식을 수정가능 </h5>
    <p>type: time -> <fmt:formatDate value="${now}" type="time" /></p>
    <p>type: both -> <fmt:formatDate value="${now}" type="both" /></p>

    <h3>패턴을 적용하여 날짜 출력</h3>
    <p>패턴1: <fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일" /></p>
    <p>패턴2: <fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 E요일 a hh시 mm분 ss초" /></p>
    <p>패턴2: <fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 E요일 HH시 mm분 ss초" /></p>
    <!-- javascript <- java 가능 -->
    <!-- javascript -> java 불가능-->

    <h3>dateStyle</h3>
    <p>dateStyle-default : <fmt:formatDate value="${now}" dateStyle="default"/></p>
    <p>dateStyle-short : <fmt:formatDate value="${now}" dateStyle="short"/></p>
    <p>dateStyle-long : <fmt:formatDate value="${now}" dateStyle="long"/></p>
    <p>dateStyle-full : <fmt:formatDate value="${now}" dateStyle="full"/></p>

    <h3>timeStyle(type="both")</h3>
    <p>timeStyle-short : <fmt:formatDate value="${now}" type="both" timeStyle="short"/></p>
    <p>timeStyle-medium : <fmt:formatDate value="${now}" type="both" timeStyle="medium"/></p>
    <p>timeStyle-long : <fmt:formatDate value="${now}" type="both" timeStyle="long"/></p>
    <p>timeStyle-full : <fmt:formatDate value="${now}" type="both" timeStyle="full"/></p>


    <h2>timeZone</h2>

    <!-- javaBean 사용 -->
    <jsp:useBean id="time" class="java.util.Date" />
    <!-- KOREA -->
    <h5>Korea Current time</h5>
    <p><c:out value="${time}" /> </p>
    <p>
    <!-- LONDON -->
      <h5>London Current Time</h5>
      <fmt:timeZone value="GMT">
        <fmt:formatDate value="${time}" type="both" dateStyle="full" timeStyle="full" />
      </fmt:timeZone>
    </p>
    <p>
    <!-- LONDON + 9HR -->
      <h5>London Current Time +9hr</h5>
      <fmt:timeZone value="GMT+9">
        <fmt:formatDate value="${time}" type="both" dateStyle="full" timeStyle="full" />
      </fmt:timeZone>
    </p>

    <p>
      <h5>US Current Time (fmt:setLocale value="en_US"/)</h5>
      <fmt:setLocale value="en_US"/>
      <fmt:formatDate value="${time}" type="both" dateStyle="full" timeStyle="full"/>
    </p>

    <h3>Function Tag</h3>
    <p>taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"</p>
    <pre>
      JSTL이 제공하는 메소드를 이용하는 태그
      <c:set var="str" value="How are you?" />
      모든문자를 대문자로 : ${fn:toUpperCase(str)}
      index찾기: ${fn:indexOf(str, "you")}
    </pre>
  </div>

</body>
</html>