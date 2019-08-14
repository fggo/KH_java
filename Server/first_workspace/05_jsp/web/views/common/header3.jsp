<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/layout1.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/register.css">
  
  <link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
  <title>회원가입</title>

</head>
<body>
  <header>  
    <div class="head">
      <div class="img center">
        <img src="<%=request.getContextPath() %>/images/moo.png" width="150px" height="150px">
      </div>
      <div class="login">
          <table>
            <tr>
              <td><%=m.getMemberName() %>님 환영합니다.</td>
            </tr>
            <tr>
              <td><button onclick="location.href='<%=request.getContextPath() %>/logout.do'">
								로그아웃
              </button>
						</td>
            </tr>
            <tr>
              <td colspan="2"><input type="submit" value="login"></td>
            </tr>
          </table>
      
        <a href="#" class="register">회원가입</a>
      </div>
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