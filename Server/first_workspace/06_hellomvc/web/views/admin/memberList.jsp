<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member, java.util.List, java.util.ArrayList" %>
<%
  //attribute 추가 데이터를 넣음
  //나중에는 JSON객체로 넘김
  // getParameter (key-value)
  // getParameterValues(array 같은 다중값)
  List<Member> list = (ArrayList<Member>)request.getAttribute("members");
%>
<style>
	section#memberList-container{text-align:center;}
	section#memberList-container table#tbl-member{
		width:100%;border:1px solid gray;
		border-collapse: collapse;
	}
	section#memberList-container table#tbl-member th,
	table#tbl-member td{
		border:1px solid gray;padding:10px;
	}
</style>

<%@ include file="/views/common/header.jsp" %>
  <section id="memberList-container">
    <h2>회원관리</h2>
    <table id="tbl-member">
      <thead>
        <tr>
          <th>아이디</th>
          <th>이름</th>
          <th>성별</th>
          <th>나이</th>
          <th>이메일</th>
          <th>전화번호</th>
          <th>주소</th>
          <th>취미</th>
          <th>가입일</th>
        </tr>
      </thead>
      <tbody>
        <% if(list !=null && !list.isEmpty()){
          for(Member m : list) { %>
            <tr>
              <td><%=m.getUserId() %></td>
            <td><%=m.getUserName() %></td>
            <td><%=m.getGender()=='M'? "남":"여" %></td>
            <td><%=m.getAge() %></td>
            <td><%=m.getEmail() %></td>
            <td><%=m.getPhone() %></td>
            <td><%=m.getAddress() %></td>
            <td><%=m.getHobby() %></td>
            <td><%=m.getEnrollDate() %></td>
          </tr>
          <% }
        } %>
      </tbody>

    </table>
  </section>
<%@ include file="/views/common/footer.jsp" %>