<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 기본적인 페이지 불러오는 방식 -->
<%-- <%@ include file="header.jsp" %> --%>
<!-- action태그를 이용한 페이지 불러오는 방식 
  jsp:param을 통해서 불러오는 페이지에  값을 전달할 수 있음!
-->
<%-- <jsp:include page="header.jsp" /> --%>
<%
  request.setCharacterEncoding("utf-8");
%>
<!-- include되는 header.jsp에 param을 넘겨줌 -->
<jsp:include page="header.jsp">
  <jsp:param name="title" value="책정보"/>
</jsp:include>    

<section class="container card">
  <%-- <h2><%=p.getName() %></h2> --%>
  <table class="table table-sm text-center my-3">
    <tr>
      <th>제목</th>
      <th>저자</th>
      <th>가격</th>    
    </tr>
    <tr>
      <td>java</td>
      <td>유병승</td>
      <td>100</td>
    </tr>
    <tr>
      <td>oracle</td>
      <td>오건철</td>
      <td>1000</td>
    </tr>
  </table>
</section>
</body>
</html>