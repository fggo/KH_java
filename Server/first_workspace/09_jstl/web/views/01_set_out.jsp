<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Core 태그를 사용하기 위해서는 tablib 지시자(directives)를 선언해야 합니다. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value=""></c:set> <!-- 패스 설정가능  -->

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
<title>Insert title here</title>
</head>
<body>
  <div class="container card my-5 col-md-6 jumbotron">

  <h2>1. JSTL출력하기</h2>
  <pre>c:out태그 이용하여 원하는 데이터를 페이지에 출력할 수 있음.
    태그 속성으로는 value가 있음.
    value에 있는 값을 출력하게 되는 로직
    value=리터럴값(문자)|EL표현식*표현시에는 "",''감싸줘야함
  </pre>

  <h3> <c:out value="첫 출력 ! 와우"></c:out> </h3>
  태그요소 텍스트노드

  <%-- <c:out>이거는될까요</c:out>   완전한 태그는 아니라서 오류. 이렇게 쓰면안됌 --%>

  <c:out value="<h3>여러분힘내고 건강관리하세요</h3>"/>
  <!-- c:out escapeXml속성 : value에 있는 html구문을 해석여부 결정  
    escapeXml 속성 : true -> html구문을 해석하지 않는것 false => 해석함
   -->
  <c:out value="<h3>여러분힘내고 건강관리하세요</h3>" escapeXml="false"/>

  <h1>2. cout은 EL을 이용하여 사용가능</h1>

  <c:out value="${'안녕 EL로 표현'}"/>
  <c:out value="${20*30}"/>
  <c:out value="${20<30}"/>

  
  <h1>3. c: set태그를 이용 </h1>
  <h4>변수생성 값대입</h4>
  <pre>
    속성 : var, value
    var -> 변수명이랑 동일하다고 보면됨, EL이 이명칭으로 호출하게됨.
    value -> var명칭에 들어갈 값
  </pre>

  <c:set var="name" value="류별리 완죤지각"/>
  <!-- page객체 안에 name key값을 만들고 value를 저장  -->
  <h1>${name}</h1>
  <h1 style="color: red"><c:out value="${name}"/></h1>
  
  <h1>불러왔을때 없는 값일 경우 default값을 설정할 수 있음</h1> 
  <c:set var="age" value="20"/>
  <h3><c:out value="${age}" default="19"/></h3>
  
  <h1>set으로 객체 넣기</h1>
  <c:set var="item" value='<%=new jstl.model.vo.Item("검",10,1)%>'/>
  <c:out value="${item}"/><br/>
  <c:out value="${item.name}"/><br/>
  <c:out value="${item.level}"/><br/>

  <c:set var="today" value='<%=new java.util.Date()%>'/>
  <c:out value="${today}"/>

  <c:set var="result" value="${10*20}"/><br/>
  <c:out value="${result}"/><br/>
  
  <h1>set할때 저장하는 객체를 변경할 수 있음 * 기본 : page
  Scope속성 이용</h1><br/>
  <c:set var="age" value="21" scope="request"/><br/>
  <c:set var="age" value="19" /><br/>
  <c:set var="age" value="28" scope="session"/>

  <c:out value="${age}"/><br/>
  <c:out value="${requestScope.age}"/><br/>
  <c:out value="${sessionScope.age}"/><br/>
  
  <h1>객체의 멤버변수의 값을 변경할 수도 있음
  target속성을 이용해서 대상이 되는 객체를 지정하여 변경함.</h1><br/>
  <c:set target="${item}" property="name" value="최장원"/><br/>
  <c:out value="${item}"/><br/>
  
  <h1>
    <pre>
      저장된 값을 지우기
      c : remove태그를 사용
      속성 : var, scope
      var : 저장되어있는 값의 변수명 입력
      scope : 그 변수가 있는 범위를 지정
    </pre>
  </h1><br/>
  <c:out value="지우기 전 값 : ${age}" /> <br/>
  <c:remove var="age" scope="page"/> <!-- 지우기  특정 범위 지정 가능-->
  <c:out value="지운값 : ${age}" /> <br/>
  <c:out value="지운값 : ${requestScope.age}" /> <br/>
  <c:out value="지운값 : ${sessionScope.age}" /> <br/>
  
  
  </div>
</body>
</html>