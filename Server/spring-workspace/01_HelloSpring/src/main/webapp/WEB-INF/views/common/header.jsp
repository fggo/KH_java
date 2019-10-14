<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>${ param.pageTitle }</title>

  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
  <!-- jQuery Custom Scroller CDN -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>

  <!-- JAVASCRIPT -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
    integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


  <!-- CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
    integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  
  <!-- Custom CSS -->
  <link rel="stylesheet" href="${path }/resources/css/style.css">

  <!-- Scrollbar Custom CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">

  <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
  <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>

  <!-- 사용자작성 css -->
  <link rel="stylesheet" href="${path }/resources/css/style.css" />

</head>
<body>
<div id="container">
  <header>
    <div id="header-container">
      <h2>${ param.pageTitle }</h2>
    </div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <a class="navbar-brand" href="#">
        <img src="${path }/resources/images/logo-spring.png" alt="스프링로고" width="50px" />
      </a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item"><a class="nav-link" href="${path }">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="${path }/board/boardList.do">게시판</a></li>
            <!-- <li class="nav-item"><a class="nav-link" href="${path }/demo/demo.do">Demo</a></li> -->
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Demo </a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="${path }/demo/demo.do">Dev 등록</a>
                <a class="dropdown-item" href="${path }/demo/selectDevList.do">Dev 목록</a>
              </div>
            </li>
            <li class="nav-item"><a class="nav-link" href="${path }/memo/memo.do">메모</a></li>
          </ul>
          <c:if test="${empty loginMember}">
            <button class="btn btn-outline-success my-2 my-sm-0" type="button" data-toggle="modal" 
              data-target="#loginModal">로그인</button>&nbsp;
            <button class="btn btn-outline-success my-2 my-sm-0" type="button" 
              onclick="location.href='${path }/member/memberEnroll.do'">회원가입</button>
          </c:if>

          <div>
            <c:if test="${not empty loginMember}">
              <span><i class="fa fa-person"></i></span>
              <span><a href="#">Hello ${loginMember.userName}</a>. Welcome Back!</span>&nbsp;
              <button class="btn btn-outline-success my-2 my-sm-0" type="button" 
                onclick="location.href='${path}/member/memberLogout.do'">Log Out</button>
            </c:if>
          </div>
        </div>
        <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" 
          aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">로그인</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
            
              <form action="${path }/member/memberLogin.do" method="post">
                <div class="modal-body">
                  <input type="text" class="form-control" name="userId" placeholder="아이디" required>
                  <br />
                  <input type="password" class="form-control" name="password" placeholder="비밀번호" required>
                </div>
                <div class="modal-footer">
                  <button type="submit" class="btn btn-outline-success" >로그인</button>
                  <button type="button" class="btn btn-outline-success" data-dismiss="modal">취소</button>
                </div>
              </form>
            </div>
          </div>
        </div>
    </nav>
  </header>