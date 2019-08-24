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
<title>ID or PW does Not match!</title>
</head>
<body>

<h1 style="color:red">Error! ID or Password Does Not Match!</h1>

<script>

  alert(<%=msg %>);

  location.href="<%=request.getContextPath() %><%=loc %>";

</script>

</body>
</html>