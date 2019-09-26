<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.js"></script>
</head>
<body>
  <h1>기본EL표현식 활용하기!</h1>
  <%
    String name="유병승";
    int su=19;
    int su2=20;
    java.util.List<action.model.vo.Person>list=new java.util.ArrayList();
    
    request.setAttribute("su", su);
    request.setAttribute("su2", su2);
    request.setAttribute("name", name);
    request.setAttribute("list", list);
  %>
  <p><%=su %></p>
  <p>${su }</p>????? 
    => (request|session|application).getAttribute("su");
  <h2>EL표현식 연산</h2>
  <p>EL표현식 안에서 연산처리하는것 
    연산처리시 에는 두개의 값이 있는데 두개의 값은 변수 혹은 리터럴도 가능</p>
  <p>더하기연산 : ${10+10 }</p>
  <p>변수이용 : ${su+10 }</p>
  <p>두개다 변수이용 : ${su+su2 }</p>
  <p>두개다 변수이용 : ${su*su2 }</p>
  <p>두개다 변수이용 : ${su/su2 }</p>
  <p>두개다 변수이용 : ${su % su2 }</p>
  <p>두개다 변수이용 : ${su div su2 }</p>
  <p>두개다 변수이용 : ${su mod su2 }</p>
  <h3>비교연산/논리연산</h3>
  <p>${name == "유병승" }</p>
  <p>${su == su2 }</p>
  <p>${su eq su2 }</p>
  <p>${su eq 19 }</p>
  <p>${su > su2 }</p>
  <p>${su gt su2 }</p>
  <p>${su lt su2 }</p>
  <p>${su < su2 }</p>
  논리연산은?? and, or
  <p>${name eq "유병승" and su gt su2 }</p>
  <p>${name eq "유병승" or su gt su2 }</p>
  부정연산
  <p>${name != "유병승" }</p>
  <p>${name ne "특수기호" }</p>
  객체 빈값확인
  <p>${list == null }</p>//list변수에 값이 있는지 확인할때
  <p>${list.size()==0 }</p>
  <p>${empty list }</p>//실제 리스트에 오브젝트값들이 있는지 여부를 확인할때!
  <p>${list!=null and empty list }</p>
  <%-- <c:if test="${list!=null and empty list }">
      
  </c:if> --%>
  
</body>
</html>












