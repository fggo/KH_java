<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.prac.model.vo.Member" %>
  
<%@ include file="/views/common/header.jsp" %>

<div class="col-md-6 mx-auto row justify-content-center align-items-center">
  <div class="card">
    <div class="card-body ">
      <form class="form-signin">
        <div class="text-center mb-4">
          <img class="mb-4" src="<%=request.getContextPath() %>/images/bootstrap-solid.svg" alt="" width="72" height="72">
          <h1 class="h3 mb-3 font-weight-normal">Log In</h1>
        </div>

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
      </form>
    </div>
  </div>
</div>

<%@ include file="/views/common/footer.jsp" %>