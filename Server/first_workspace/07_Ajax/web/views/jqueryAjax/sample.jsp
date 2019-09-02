<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList, com.ajax.model.vo.Member" %>
<%
  List<Member> list = (ArrayList<Member>)request.getAttribute("list");
%>
  <table id="tbl-member">
    <tr>
      <th>프로필</th>
      <th>이름</th>
      <th>전화번호</th>
    </tr>
    <% if(!list.isEmpty()) {
      for(Member m : list){
    %>
    <tr>
      <td>
        <img src="<%=request.getContextPath() %>/images/<%=m.getProfile() %>"/>
      </td>
      <td>
        <%=m.getName() %>
      </td>
      <td>
        <%=m.getPhone() %>
      </td>
    </tr>
    <%}
    } %>
  </table>
  <style>
    img{width:100px; }
  	table{border:1px solid; border-collapse:collapse;}
  	th,td{border:1px solid; padding:10px;}
  </style>