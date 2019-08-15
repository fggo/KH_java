<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.jsp.model.vo.Member" %>
<%
  Member m = (Member)request.getAttribute("member");
%>

<% if(m == null){ %>
  <%@ include file="../common/header.jsp" %>
<%} else{ %>
  <%@ include file="../common/header_logged.jsp" %>
<%} %>

		<article>
			<div class="wrap">
				<div class="bar">
					<br><br><br><br><br>
					<h1>회원가입</h1> <br>
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
<%@ include file="../common/footer.jsp" %>