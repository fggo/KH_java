<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  boolean isUseable = (boolean)request.getAttribute("isUseable");
  String userId = (String)request.getAttribute("userId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복검사</title>
<style>
  div#checkid-container{
    text-align: center;
    padding-top:50px;
  }
  span#duplicated{
    color:red;
    font-weight: bold;
  }
</style>
</head>
<body>
  <div id="checkid-container">
    <% if(isUseable){%>
      [<span><%=userId %></span>]는 사용가능합니다.
      <br><br>
      <button type="button" onclick="setUserId();" >닫기</button>
    <%} else{ %>
      [<span id="duplicated"><%=userId %></span>]는 이미 사용 중 입니다.
      <br><br>
      <form action="<%=request.getContextPath() %>/checkIdDuplicate"
        method="post" name="checkId">
        <input type="text" name="userId" id="userId"
          placeholder="아이디를 입력하세요"/>&nbsp;&nbsp;
        <button type="button" onclick="checkIdDuplicate();">중복검사</button>
      </form>
    <%} %>

  </div>
  <script>
    function checkIdDuplicate(){
      // var userId = document.getElementById("userId").value;
      var userId = $('#userId').val();

      if(!userId || userId.trim().length<4){
        alert("아이디는 4글자 이상 가능합니다.")
        return;
      }

      //form 태그에 접근
      checkId.userId.value = userId.trim();
      checkId.submit();
    }

    function setUserId(){
      //부모객체에 값 넣어주기
      opener.document.getElementById("userId_").value = "<%=userId%>";
      // opener.document.getElementById("userId_").setAttribute("disabled", "true");
      opener.document.getElementById('password_').focus();
      self.close();
    }

  </script>
  <!-- jQuery -->
  <script src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js"></script>
</body>
</html>