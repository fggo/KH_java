<!-- 지시자 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" %>
    <!-- 
    .지시자
    페이지에 대한 설정을 하는 영역
  page: 사용 언어, 인코딩언어, 다른 패키지 객체 import,
  error페이지 선언 등
     -->
<%!
  /* 선언문 
           변경되는 클래스의 멤버변수, 멤버메소드를 선언
   */
  private Date today = new Date();
  public Date getDate(){
    return today;
  }
%>

<%
	/* 스크립트
	jsp_service메소드 안에 들어갈 자바코드
	지역변수, 조건문, 반복문, 기본 자바처리 로직
	*/
  // out.println() == response.getWriter().out
	String name ="유병승";
	if(name.equals("유병승")){
	  out.println("정말 멋지네요!");
	}
	for(int i =0; i<10; i++){
	  out.println(i);
	}
	String[] foods = {"김밥", "도시락", "핫바", "닭강정"};
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>연결되는 페이지</title>
</head>
<body>
  <h1>난 요청한 페이지야!</h1>
  <% name="유병승"; %>
  <p>내 이름은 <%=name %> 입니다. </p>
  <%-- 
		<%= %> 는 출력문: 뒤에 있는 구문을 매개변수로
		out.println(출력문); 호출 
	--%>
	<h1><%=today %></h1>
	<ul>
		 <%for(String f: foods){ %>
			 <li><%=f %></li>
		 <%} %>
	</ul>
	<script>
	 //url 쿼리스트링
	 location.href = "/프로젝트명/login.do?name";
	 //데이터 보낼때 sendRedirect 쓰지않음
	</script>
</body>
</html>