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
<title>반복문 처리하기</title>
</head>
<body>
  <div class="container card my-5 jumbotron py-3 px-3 col-md-6">

    <h1>태그를 이용해서 반복문 처리하기</h1>

    <h4>
      <pre>
        c:forEach 태그를 활용해서 반복문 로직을 처리할 수 있음
        2가지 배열, 리스트 값을 반복문으로 해결!
        기본for문 1 ~ 10까지 반복
        
        리스트, 배열 속성 : items -> 배열, 값
                  var -> 배열리스트의 인덱스 값이 들어가는 변수
                  varStatus -> 반복문에 대한 정보를 가지고 있는 객체
                  - 인덱스값, 반복문 회전갯수, 반복이 처음, 마지막
        기본for
        속성 : begin : 시작값
            end : 종료값
            var : begin에서 증가되는 값
            step : 시작 ~ 종료까지 값이 증가하는 범위
      </pre>
    </h4><br/>
    
    <%
      String[] names = {"유병승","여동규","김기호","박기오"};
      request.setAttribute("names", names);
    %>

    <c:forEach var="name" items="${names}" varStatus="s">
      <c:if test="${name == '유병승'}">
        <p>${name}천재</p>
      </c:if>
      <c:if test="${name != '유병승'}">
        <p>${name}</p>
      </c:if>
    </c:forEach>
    
    <h1>클라이언트가 보낸 다중값 출력하기</h1>
    <c:forEach var="h" items="${paramValues.hobby }" varStatus="s">
      <p>'${h}' =  인덱스 ${s.index}에 있는 값 = ${s.count}번째 element</p>
    </c:forEach>
    
    <h2>for문을 이용해서 순차적으로 출력하기</h2>
    <c:forEach var="i" begin="1" end="10" step="3">
      <span>${i}</span>
    </c:forEach>

    <%
      java.util.List<jstl.model.vo.Item> list = new java.util.ArrayList<jstl.model.vo.Item>();
      list.add(new jstl.model.vo.Item("검",11,5));
      list.add(new jstl.model.vo.Item("스태프",6,2));
      list.add(new jstl.model.vo.Item("방패",3,9));
      list.add(new jstl.model.vo.Item("가지",1,10));
      request.setAttribute("items", list);
    %>
    <table class='table table-sm my-3'>
      <tr>
        <th>이름</th>
        <th>레벨</th>
        <th>HP</th>
      </tr>
      <c:forEach var="item" items="${items}" varStatus="i">
        <tr>
          <td><c:out value='${item.name}'/></td>
          <td><c:out value='${item.defense}'/></td>
          <td><c:out value='${item.level}'/></td>
        </tr>    
      </c:forEach>
      
    
    </table>
    
  </div>

</body>
</html>