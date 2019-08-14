<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" %>

<%@ page import="java.util.Date, java.util.ArrayList" %>
<!-- import 할 때는 반드시 전체경로(package까지 포함) -->

    <!-- 
			지시자(directive) <%-- <%@ %> --%>
			다중값은 comma로 구문하여 추가 가능
			예약어가 있음 : page, include, taglib
			1. page : 기본 jsp를 구성하는 정보 설정
			   language, contexttype, pageencoding, import
			   error페이지
			2. include : 외부에 다른 jsp파일을 불러오는 것
			   * header, footer 페이지를 불러올 때 쓰임.
			3. taglib : 외부에서 작성된 libary를 불러올 때 사용
			   * JSTL을 불러올 때 사용.
     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_지시자 page.jsp</title>
</head>
<body>
  <h2>오늘 날짜</h2>
  <h3><%=new Date() %></h3>
  <h3><%=new ArrayList() %></h3>
  <!--  날짜를 시간 날짜 표현(월, 일)을 String.format() 메소드를 이용하여 처리해 보자. 
        날짜  타입  format  ||               설명
      ------------------------------------------------
      %tF                     날짜를 yyyy-mm-dd 형식으로 포맷
      %tT                     날짜의 시각을 HH:MM:SS 형식으로 포맷.
      ------------------------------------------------------
      %tY                     4자리 년도만 출력 
      %ty                     2자리 년도
      %tB                     월의 이름(January, February, March...)
      %tm                     월을 01,02,03 ~12 로 출력
      %td                     일수를 1~31 로 출력
      %te                     %td 와 같음.
      %tA                     요일명 출력
      ---------------------------------------------------
      %tp                     오전, 오후를 출력
      %tk                     시간을 0~23 으로 출력.
      %tl                     시간을 1~12 로 출력.
      %tM                     분을 00 ~59 로 출력.
      %tS                     초를 00 ~ 59 로 출력.
      -----------------------------------------------------
      %tZ                     타임존을 출력 (한국은 KST)
      ---------------------------------------------------
      --> 
  <%
    Date today = new Date();
    //yyyy-mm-dd
    String date = String.format("%tF", today);
    //오전||오후 hh:mm:ss
    String time = String.format("%tp %tT", today,today);
    //yyyy년m월d일 요일
    String day = String.format("%tY년 %tm월 %td일 %tA", today,today,today,today);
  %>
  <ul>
    <li><%=date %></li>
    <li><%=time %></li>
    <li><%=day %></li>
  </ul>

</body>
</html>