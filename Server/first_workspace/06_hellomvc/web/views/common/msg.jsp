<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String msg = (String)request.getAttribute("msg");
  String loc = (String)request.getAttribute("loc");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메세지 창</title>
</head>
<body>
  <script>
/* 스크립트릿에서 작성한 코드는 반드시 표현식 방식으로 처리 */
    alert('<%=msg%>');

    //페이지 이동 방법 3가지
    // 1.location : location.href="url"; 브라우저에서 주소창 url로 반환
    // 2.<a>, <form> (사용자가 이벤트 자동발생 시켜야 가능 trigger 이용)
    // 3.window.open (사용자가 이벤트 발생 시켜야 가능 trigger 이용)
    //메인화면으로 이동 : 
    location.href = "<%=request.getContextPath()%><%=loc%>";
  </script>

</body>
</html>