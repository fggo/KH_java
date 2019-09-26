<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="03_forEach.jsp" method="get">
		<input type="checkbox" name="hobby" value="자바">자바
		<input type="checkbox" name="hobby" value="HTML&CSS">HTML&CSS
		<input type="checkbox" name="hobby" value="자바스크립트">자바스크립트
		<input type="checkbox" name="hobby" value="오라클">오라클
		<input type="checkbox" name="hobby" value="jsp&servlet">jsp&servlet
		<input type="submit" value="전송"/>
	</form>
</body>
</html>