<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="./common/header.jsp" %>
<section>
  <h1>여기는 content 영역입니다.</h1>
  <img src="https://vignette.wikia.nocookie.net/dayshift-at-freddys/images/9/94/DoggoInfobox.png/revision/latest?cb=20181113014231"
  width="200px" height="200px">
  <div>
    <ul>
      <%for(String name : list){ %>
				<li><%=name %></li>
			<%} %>
    </ul>
  </div>
</section>
<%@ include file="/views/common/footer.jsp" %>