<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.prac.model.vo.Member" %>
  
<%
  Member m = request.getAttribute("loginMember");
%>

<%@ include file="/views/common/header.jsp" %>

<form class="form-signin" action="<%=request.getContextPath() %>/login" method="post">
  <div class="col align-self-center">
    <div class="card">
      <div class="card-body ">
        <div class="text-center mb-4">
          <img class="mb-4" src="<%=request.getContextPath() %>/images/bootstrap-solid.svg" alt="" width="72" height="72">
          <h1 class="h3 mb-3 font-weight-normal">Log In</h1>
        </div>
          

        <% if(m != null){%>
          <div class="form-label-group">
            <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="" >
            <label for="inputEmail">Email address</label>
          </div>
      
          <div class="form-label-group">
            <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">
            <label for="inputPassword">Password</label>
          </div>
      
          <div class="checkbox mb-3">
            <label>
              <input type="checkbox" value="remember-me"> Remember me
            </label>
          </div>

          <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <%}else{ %>
          <div class="form-label-group">
            <p class="h3">Hello <%=m.getUserName() %>!</p>
          </div>
          <button class="btn btn-lg btn-primary btn-block" type="submit">Sign out</button>
        <%} %>
        </div>
      </div>
    </div>
  </form>

<%@ include file="/views/common/footer.jsp" %>