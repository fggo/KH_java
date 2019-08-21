<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.prac.model.vo.Member" %>
  
<%
  Member m = (Member)request.getAttribute("loginMember");
%>

<%@ include file="/views/common/header.jsp" %>

<div class="col align-self-center">
  <div class="card">
    <div class="card-body ">
      <div class="text-center mb-4">
        <img class="mb-4" src="<%=request.getContextPath() %>/images/bootstrap-solid.svg" alt="" width="72" height="72">
        <h1 class="h3 mb-3 font-weight-normal">Log In</h1>
      </div>
      
      <% if(m == null){%>
        <form class="form-signin" action="<%=request.getContextPath() %>/login" method="post">
          <div class="form-label-group">
            <input type="text" id="id" name= "id" class="form-control" placeholder="user Id" required="" autofocus="" >
            <label for="id">Email address</label>
          </div>
      
          <div class="form-label-group">
            <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
            <label for="password">Password</label>
          </div>
      
          <div class="checkbox mb-3">
            <label>
              <input type="checkbox" id="rememberId" name="rememberId" value="remember-me"> Remember me
            </label>
          </div>

          <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        </form>
        <%}else{ %>
          <form action="<%=request.getContextPath() %>/logout">
            <div class="form-label-group">
              <p class="h3">Hello <%=m.getUserName() %>!</p>
            </div>
            <input class="button btn btn-lg btn-primary btn-block" type="submit" value="Sign out">
          </form>
        <%} %>
      </div>
    </div>
  </div>

<%@ include file="/views/common/footer.jsp" %>