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
  <h2>import태그 사용하기</h2>
  <p>
    현재페이지에 다른 페이지 넣는것
    jsp:include 코드가 작성된 곳에 바로 출력
    변수에 삽입될 페이지를 저장함.
    EL로 출력문을 작성했을때 그 위치에서 출력
    c:import태그
    속성: url, var
    url -> 불러올페이지 경로
    var -> 저장 변수
    파라미터값을 보낼수 있음
  </p>
  <c:import var="p" url="01_set_out.jsp"/>
  <jsp:include page="02_if_when.jsp">
    <jsp:param value="책정보" name="title"/>
  </jsp:include>
  <h2>넌왜안나와</h2>
  ${p}
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
  

  

</body>
</html>