<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>여긴 에러페이지!!!</title>
</head>
<body>
	<!-- web.xml에 모든 exception에 대한 공통 에러페이지 등록가능 -->
<%--   <h1 style="color:red;">"<%=exception.getMessage() %>" EXCEPTION 에러!</h1>
 --%>
  <h1 style="color:red;">EXCEPTION 에러!</h1>
	<p>3초후 메인화면으로 이동합니다.<p>
  <script>
    setTimeout(function(){
      location.href="<%=request.getContextPath()%>/index.jsp";
    },3000)
  </script>

</body>
</html>