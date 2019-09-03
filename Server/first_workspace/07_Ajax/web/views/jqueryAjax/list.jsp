<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List, java.util.ArrayList" %>
<%
  List<String> list = (ArrayList<String>)request.getAttribute("list");
%>

  <% if(!list.isEmpty()){
    for(String userId : list){ %>
      <option value="<%=userId %>"><%=userId %></option>
  <%  }
  } %>