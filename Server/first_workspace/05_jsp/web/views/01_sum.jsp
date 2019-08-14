<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int sum=0;
	for(int i = 1; i <= 10; i++){
		sum += i;
	}
	//error!!!
	int total = sum/0; //divide by zero error
%>
<div>1부터 10까지의 합 = 
	<%=sum %>
</div>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1부터 10까지 합 구하기</title>
</head>
<body>
  <h1>1부터 10까지의 합</h1>
    <p style="color:green"> = <%=sum %></p>

</body>
</html>