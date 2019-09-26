<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>당산이 좋아하는 음식을 고르세요</h1>
  <form action="02_if_when.jsp" method="post">
    <select name="food">
      <option value="족발">족발</option>
      <option value="연어회">연어회</option>
      <option value="곱창">곱창</option>
      <option value="치킨">치킨</option>
      <option value="삼겹살">삼겹살</option>
    </select>
    <input type="submit"/>
  </form>

</body>
</html>