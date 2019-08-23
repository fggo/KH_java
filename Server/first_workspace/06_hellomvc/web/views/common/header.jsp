<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.member.model.vo.Member" %>

<%
  //get Member object from servlet dispatcher call
  //Member loginMember = (Member)request.getAttribute("loginMember");
  Member loginMember = (Member)session.getAttribute("loginMember");
  
  //cookie 쿠키값 확인해서 페이지에 반영하기
  //cookie는 key:value형식으로 여러개 저장이 가능하기 때문에

  //쿠키 객체가 배열로 저장이 됨
  Cookie[] cookies = request.getCookies();
  String saveId = null;

  if(cookies != null){
    for(Cookie c : cookies){
      //내가 원하는 cookie 객체를 찾아서 값을 처리
      //key, value를 method를 이용해서 가져올 수 있음
      //f5 refesh 눌러도 바뀌지 않음
      //쿠키에 session도 담김
      String key = c.getName();
      String value = c.getValue();
      System.out.println("key : " + key);
      System.out.println("value : " + value);

      if(key.equals("saveId")){
        saveId = value;
      }
    }
  }
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
<!-- jQuery -->
<script src="<%=request.getContextPath()%>/js/jquery-3.4.1.min.js"></script>
<!-- JS -->

<meta charset="UTF-8">
<title>Hello MVC!</title>
</head>
<body>
  <header>
    <h1>HelloMVC</h1>
    <!--로그인 메뉴-->
    <div class="login-container">
      <% if(loginMember == null) {%>
        <form id='loginFrm' 
        action="<%=request.getContextPath() %>/login" 
        method="post" onsubmit="return validate();">
          <table>
            <tr>
              <td>
                <input type="text" name="userId" 
                placeholder="아이디" id="userId" value='<%=saveId !=null? saveId:""%>' />
              </td>
            </tr>
            <tr>
              <td>
                <input type="password" name="password"
                  placeholder="비밀번호" id="password"/>
              </td>
              <td>
                <input type="submit" value="로그인"/>
              </td>
            </tr>
            <tr>
              <td colspan='2'>
                <input type="checkbox" name="saveId"
                id="saveId" <%= saveId!=null? "checked":"" %> />
                <label for="saveId">아이디저장</label>
                <input type="button" value="회원가입"
                onclick="location.href='<%=request.getContextPath()%>/memberEnroll'">
              </td>
            </tr>
          </table>
        </form>
      <%} else{%>
        <table id="logged-in">
          <tr>
            <td>
              <%=loginMember.getUserName() %>님 환영합니다!
            </td>
          </tr>
          <tr>
            <td>
              <input type="button" value="내정보보기" 
                  onclick="location.href='<%=request.getContextPath()%>/mypage?userId=<%=loginMember.getUserId()%>'"/>
              <input type="button" value="로그아웃" 
                onclick="location.href='<%=request.getContextPath()%>/logout'"/>
            </td> <!-- <%%> == out.write("") -->
          </tr>
        </table>
      <%} %>
    </div>
    <nav>
      <ul class="main-nav">
        <li class="home">
          <a href="<%=request.getContextPath()%>">Home</a>
        </li>
        <li id="notice">
          <a href="#">공지사항</a>
        </li>
        <li>
          <a href="#">게시판</a>
        </li>
        <li>
          <a href="#">사진게시판</a>
        </li>

        <!-- 관리자페이지 -->
        <% if(loginMember!= null && loginMember.getUserId().equals("admin")){ %>
          <li id="admin-member">
            <a href="<%=request.getContextPath() %>/admin/memberList">회원관리
              <span class="animate_line"></span>
            </a>
          </li>
        <% } %>
      </ul>
    </nav>
  </header>

  <script>
    /* validate id/pw user input */
    function validate(){
      if($('#userId').val().length==0){
        alert("아이디를 입력하세요!")
        $('#userId').focus();
        return false; //form 제출 막는 것
      }
      if($('#password').val().length==0){
        alert("비밀번호를 입력하세요!")
        $('#password').focus();
        return false; //form 제출 막는 것
      }
      return true;
    }
  </script>
