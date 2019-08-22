<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  Member m = (Member)request.getAttribute("member");
  String[] hobbyCheck = new String[5];
  // jquery이용한 checkbox 개수 front에서 backend로 가져올 수 없음
  if(m.getHobby() !=null){
    String[] hobbies = m.getHobby().split(",");
    for(String h : hobbies){
      switch(h){
        case "운동": hobbyCheck[0] = "checked"; break;
        case "등산": hobbyCheck[1] = "checked"; break;
        case "독서": hobbyCheck[2] = "checked"; break;
        case "게임": hobbyCheck[3] = "checked"; break;
        case "여행": hobbyCheck[4] = "checked"; break;
      }
    }
  }
%>

<%@ include  file="/views/common/header.jsp" %>
<section id="enroll-container">
  <h2>회원가입 정보수정</h2>
  <form id="memberFrm" action="<%=request.getContextPath()%>/" method="post" 
    onsubmit="return update_validate();">
    <table>
      <tr>
        <th>아이디</th>
        <td>
          <input type="text" value="<%=m.getUserId() %>"
            name="userId" id="userId_" readonly>
        </td>
      </tr>
      <tr>
        <th>이름</th>
        <td>
          <input type="text" id="userName"
          name="userName" value="<%=m.getUserName() %>" >
        </td>
      </tr>
      <tr>
        <th>나이</th>
        <td>
          <input type="number" name="age" id="age" value="<%=m.getAge()%>" ><br>
        </td>
      </tr>
      <tr>
        <th>이메일</th>
        <td>
          <input type="email" value="<%=m.getEmail()%>" id="email" name="email"><br/>
        </td>  
      </tr>
      <tr>
        <th>휴대폰</th>
        <td>
          <input type="tel" name="phone" value="<%=m.getPhone() %>" id="phone" ><br/>
        </td>
      </tr>
      <tr>
        <th>주소</th>
        <td>
          <input type="text" name="address" value="<%=m.getAddress()%>" id="address"><br>        
        </td>
      </tr>
      <tr>
        <th>성별</th>
        <td>
          <%if('M'==m.getGender()){ %>
            <input type="radio" name="gender" 
            id="gender0" value="M" checked>
            <label for="gender0">남</label>
            <input type="radio" name="gender" 
            id="gender1" value="F">
            <label for="gender1">여</label>
          <%}else{ %>
            <input type="radio" name="gender" 
            id="gender0" value="M">
            <label for="gender0">남</label>
            <input type="radio" name="gender" 
            id="gender1" value="F" checked>
            <label for="gender1">여</label>
          <%} %>
        </td>
      </tr>
      <tr>
        <th>취미</th>
        <td>
          <input type="checkbox" name="hobby" 
            id="hobby0" value="운동" <%=hobbyCheck[0] %>>
          <label for="hobby0">운동</label>
          <input type="checkbox" name="hobby"
            id="hobby1" value="등산" <%=hobbyCheck[1] %>>
           <label for="hobby1">등산</label>
          <input type="checkbox" name="hobby"
            id="hobby2" value="독서" <%=hobbyCheck[2] %>>
           <label for="hobby2">독서</label>
          <input type="checkbox" name="hobby"
            id="hobby3" value="게임" <%=hobbyCheck[3] %>>
           <label for="hobby3">게임</label>
          <input type="checkbox" name="hobby"
            id="hobby4" value="여행" <%=hobbyCheck[4] %>>
           <label for="hobby4">여행</label>
        </td>
      </tr>
    </table>
    <input type="button" value="비밀번호 변경" onclick="updatePassword();" />
    <input type="button" value="수정" onclick="updateMember();" />
    <input type="button" value="탈퇴" onclick="deleteMember();" />
  </form>

  <form action="" method="post" name="checkIdDuplicateFrm">
    <input type="hidden" name="userId">
  </form>

  <form action="" method="post" name="updatePasswordFrm">
    <input type="hidden" name="pw">
  </form>

</section>

<script>
  function update_validate(){
    return true;
  }
  function updateMember(){
    var frm = $('#memberFrm');
    var url="<%=request.getContextPath() %>/member/memberUpdate"; //WebServlet
    frm.attr("action", url);
    frm.submit();
  }
  function deleteMember(){
    if(confirm("정말로 삭제 하시겠습니까?")){
      // var frm = $('#memberFrm');
      // var url="<%=request.getContextPath() %>/member/memberDelete"; //WebServlet
      // frm.attr("action", url);
      // frm.submit();
      //1.
      // location.href="<%=request.getContextPath()%>/member/memberDelete?userId=<%=loginMember.getUserId()%>";
      //2.
      // location.href="<%=request.getContextPath()%>/member/memberDelete?userId=<%=loginMember.getUserId()%>";
      //3.
      // location.href="<%=request.getContextPath()%>/member/memberDelete?userId=<%=m.getUserId()%>";
      //4.
      location.href="<%=request.getContextPath()%>/member/memberDelete?userId=" + $('#userId_').val();
    }
    else{
      // location.href="<%=request.getContextPath()%>/member/memberDelete?userId=<%=loginMember.getUserId()%>";
    }
  }

  //mapping: /member/updatePassword
  function updatePassword(){
    var url="<%=request.getContextPath() %>/member/updatePassword?userId=<%=loginMember.getUserId() %>";
    var title="updatePassword";
    var status="left=500px, top=200px, width=400px, height=210px";
    open(url,title,status);
  }
</script>

<%@ include  file="/views/common/footer.jsp" %>