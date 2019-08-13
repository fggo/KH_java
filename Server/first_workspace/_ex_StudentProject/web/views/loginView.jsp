<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.servlet.model.vo.Member" %>
    <%
			Member m = (Member)request.getAttribute("member");
    %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" type="text/css" href="css/layout1.css">
  <link rel="stylesheet" type="text/css" href="css/register.css">
  
  <link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
  <title>회원가입</title>

</head>
<body>
  <header>  
  <div class="head">
    <div class="img center">
        <img src="./images/moo.png" width="150px" height="150px">
    </div>
    <% if(m==null) { %>
    <div class="login">
        <table>
            <tr>
                <td style="float: right">ID</td>
                <td><input type="text" name="id" id="inputid"><br></td>
            </tr>
            <tr>
                <td>PASSWORD</td>
                <td><input type="text" name="pw" id="inputpw"></td>
            </tr>


        </table>
        <input type="submit" value="login" id="inputlogin"><br>
        <a href="#" class="register">회원가입</a>
    </div>
    <%}else{ %>
    <div class='login'>
      <table>
            <tr>
                <td><%=m.getMemberName() %>님 환영합니다.</td>
            </tr>
            <tr>
                <td><button oncick="logout();">로그아웃</button></td>
            </tr>
        </table>
    </div>
    <%} %>
  </div>
    <nav>
      <ul class="center">
        <li class="mainshadow"><a href="#">HOME</a></li>
        <li class="mainshadow"><a href="#">뷰티</a>
          <ul>
            <li class="subshadow"><a href="#">메이크업</a></li>
            <li class="subshadow"><a href="#">네일</a></li>
            <li class="subshadow"><a href="#">헤어</a></li>
          </ul>
        </li>
        <li class="mainshadow"><a href="#">동영상</a>
          <ul>
            <li class="subshadow"><a href="#">마케팅</a></li>
            <li class="subshadow"><a href="#">편집</a></li>
            <li class="subshadow"><a href="#">촬영</a></li>
          </ul>
        </li>
        <li class="mainshadow"><a href="#">운동</a>
          <ul>
            <li class="subshadow"><a href="#">헬스</a></li>
            <li class="subshadow"><a href="#">축구</a></li>
            <li class="subshadow"><a href="#">요가 / 필라테스</a></li>
          </ul>
        </li>
        <li class="mainshadow"><a href="#">음악</a>
          <ul>
            <li class="subshadow"><a href="#">기타</a></li>
            <li class="subshadow"><a href="#">DJ</a></li>
            <li class="subshadow"><a href="#">보컬</a></li>
          </ul>
        </li>
        <li class="mainshadow"><a href="#">외국어</a>
          <ul>
            <li class="subshadow"><a href="#">영어</a></li>
            <li class="subshadow"><a href="#">중국어</a></li>
            <li class="subshadow"><a href="#">스페인어</a></li>
          </ul>
        </li>
        <li class="mainshadow"><a href="#">모임 구하기!</a></li>
      </ul>
    </nav>
  </header>
  <article>
  <div>
    <ul>
			<%
        String[] hobbys=m.getHobby().split(",");
        for(String b : hobbys){
      %>
        <li><%=b %></li>
      <%} %>
    </ul>
  </div>
    <div class="wrap">
      <div class="bar">
        <br><br><br><br><br>
        <h1>회원가입</h1>
        <br>
        <hr>
      </div>
      <div class="select center">
        <div class="email">
          <p><a href="2.register2.html">이메일로<br>가입하기</a></p>
        </div>
        <div class="kakao">
          <p><a href="2.register2.html">카카오로<br>가입하기</a></p>
        </div>
        <div class="naver">
          <p><a href="2.register2.html">네이버로<br>가입하기</a></p>
        </div>
      </div>
      <div class="bottom center">
        <span><input type="checkbox" name="agree" class="agree"><label>정보제공에 동의합니다.</label></span>
        <!-- <br>
        <input type="submit" value="다음" class="next center"> -->
      </div>
    </div>


  </article>
  <footer>
    <div class="footmenu">
      <ul class="center">
        <li class="mainshadow"><a href="#">공지사항</a></li>
        <li class="mainshadow"><a href="#">이벤트</a></li>
        <li class="mainshadow"><a href="#">Q&A</a></li>
      </ul>
    </div>
    <br>
    <p class="center">대표 : 정현빈 | 사업자등록번호 : 000-00-000000 주소 | 서울 강남구 테헤란로14길 6 남도빌딩 2층, 3층 </p>
    <br><p class="center">Tel. 010-5803-3236</p>
    <br><p class="center">Copyright ⓒ 2019 KH Academy</p>
    <br><br><br>

  </footer>
</body>
</html>