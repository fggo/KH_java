<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--<%@ page import="action.model.vo.Person" %>--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js"></script>
</head>
<body>
  <h2>bean을 활용한 데이터 저장 하기</h2>

  <!-- 1.jsp:useBean태그를 이용 객체를 페이지에서 만듦 -->
  <jsp:useBean id="p1" class="action.model.vo.Person" scope="request" />

  <!-- 2. 서버에서 보낸 객체로 받아오기(attribute로 보낸)  -->
  이름 : <jsp:getProperty property="name" name="p1"/>
  나이 : <jsp:getProperty property="age" name="p1"/>
  성별 : <jsp:getProperty property="gender" name="p1"/>


  <h2>bean을 활용한 데이터 저장 하기2</h2>
  <jsp:useBean id="p2" class="action.model.vo.Person" scope="request" />

  이름 : <jsp:getProperty property="name" name="p2"/>
  나이 : <jsp:getProperty property="age" name="p2"/>
  성별 : <jsp:getProperty property="gender" name="p2"/>

  <!-- 직접 데이터를 객체에 넣기  -->
  
  <h2>파라미터로 보낸 '객체' 데이터 저장하기(서블릿 setAttribute("p2") O) form으로 보낸 데이터도 받음</h2>
  <jsp:useBean id="p3" class="action.model.vo.Person" scope="request" />

  <%--<jsp:setProperty property="name" name="p3" value='<%=((action.model.voPerson)request.getAttribute("p3")).getName()%>'/>--%>
  <jsp:setProperty property="name" name="p3" param="name" />
  <jsp:setProperty property="age" name="p3" param="age"/>
  <jsp:setProperty property="gender" name="p3" param="gender"/>

  이름 : <jsp:getProperty property="name" name="p3"/>
  나이 : <jsp:getProperty property="age" name="p3"/>
  성별 : <jsp:getProperty property="gender" name="p3"/>

  <h2>파라미터로 보낸 '객체' 데이터 저장하기(서블릿 setAttribute("p3") X) form으로 보낸 데이터도 받음</h2>
  <jsp:useBean id="p4" class="action.model.vo.Person" scope="request" />

  <jsp:setProperty property="name" name="p4" param="name" />
  <jsp:setProperty property="age" name="p4" param="age"/>
  <jsp:setProperty property="gender" name="p4" param="gender"/>

  이름 : <jsp:getProperty property="name" name="p4"/>
  나이 : <jsp:getProperty property="age" name="p4"/>
  성별 : <jsp:getProperty property="gender" name="p4"/>

  <h2>form 파라미터로 보낸 '객체' 데이터 저장하기 </h2>
  <jsp:useBean id="p_form" class="action.model.vo.Person" scope="request" />

  <jsp:setProperty property="name" name="p_form" param="name" />
  <jsp:setProperty property="age" name="p_form" param="age"/>
  <jsp:setProperty property="gender" name="p_form" param="gender"/>

  이름 : <jsp:getProperty property="name" name="p_form"/>
  나이 : <jsp:getProperty property="age" name="p_form"/>
  성별 : <jsp:getProperty property="gender" name="p_form"/>
</body>
</html>