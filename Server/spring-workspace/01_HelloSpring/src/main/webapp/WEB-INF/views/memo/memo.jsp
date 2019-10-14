<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="path" value="${pageContext.request.contextPath}" />

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="" name="pageTitle"/>
</jsp:include>
<br/>
<table class="table">
  <tr>
      <th scope="col">번호</th>
      <th scope="col">메모</th>
      <th scope="col">날짜</th>
      <th scope="col">삭제</th>
  </tr>
  <c:forEach items="${list }" var="m">
    <tr>
      <td><c:out value="${m['MEMONO']}"/></td>
      <td><c:out value="${m['MEMO']}"/></td>
      <td><c:out value="${m['PASSWORD']}"/></td>
      <td><c:out value="${m['MEMODATE']}"/></td>
      <%-- <td><fmt:formatDate value="${m['MEMODATE']}" pattern="yyyy-MMM-dd"></td> --%>
      
      <%-- The value for fmt:formatDate is suppose to be a Date object (java.util.Date). If the task.startDate is a date as a String, then you need to convert it beforehand.
        <fmt:parseDate value="${task.startDate}" pattern="yyyy-MM-dd HH:mm:ss" var="myDate"/>
        <fmt:formatDate value="${myDate}" var="startFormat" pattern="yyyy-MM-dd"/> --%>
    </tr>
    <!-- 삭제/수정 -->
  </c:forEach>
  <!-- 리스트 직접구현 -->
</table>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>