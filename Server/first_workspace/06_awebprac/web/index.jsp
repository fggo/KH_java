<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" import="com.prac.model.vo.Member" %>

<%--
  Member m = (Member)request.getAttribute("loginMember");
--%>

<%@ include file="/views/common/header.jsp" %>

  <main role="main" class="flex-shrink-0">
    <div class="container">

      <div class="d-flex align-items-center p-3 my-3 text-white-50 bg-secondary rounded shadow-sm">
        <img class="mr-3" src="/docs/4.3/assets/brand/bootstrap-outline.svg" alt="" width="48" height="48">
        <div class="lh-100">
          <h6 class="mb-0 text-white lh-100">Hello MVC!</h6>
          <small>2019.08.21</small>
        </div>
      </div>
  
      <div class="my-3 p-3 bg-white rounded shadow-sm">
        <h6 class="border-bottom border-gray pb-2 mb-0">Contents</h6>

        <div class="media text-muted pt-3">
          <%-- <% if(m == null){ %> --%>
          <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32"><title>Placeholder</title><rect width="100%" height="100%" fill="#007bff"></rect><text x="50%" y="50%" fill="#007bff" dy=".3em">32x32</text></svg>
          <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
            <strong class="d-block text-gray-dark">@username</strong>
            This is a comment by @username. Hello MVC!
          </p>
          <%-- <%} else { %> --%>
          <%-- <%} %> --%>
        </div>
        <small class="d-block text-right mt-3">
          <a href="#">All updates</a>
        </small>
      </div>
    </div>
  </main>

<%@ include file="/views/common/footer.jsp" %>