<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

  <c:set var="path" value="${pageContext.request.contextPath}" />

  <jsp:include page="/WEB-INF/views/common/header.jsp">
    <jsp:param name="pageTitle" value="DemoPage" />
  </jsp:include>

  <style>
    div#demo-container{
      width: 40%;
      padding: 15px;
      margin: 0 auto;
      border: 1px solid limegreen;
      border-radius: 10px;
    }
  </style>

  <!-- views 밑에 demo/demo.jsp 생성 -->
  <section id="content">
    <div id="demo-container">
      <h2>Parameter Test</h2>
      <form action="" id="devFrm">
        <div class="form-group row">
          <label for="devName" class="col-sm-2 col-form-label">이름</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="devName" name="devName" />
          </div>
        </div>
        <div class="form-group row">
          <label for="devAge" class="col-sm-2 col-form-label">나이</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="devAge" name="devAge" />
          </div>
        </div>
        <div class="form-group row">
          <label for="devEmail" class="col-sm-2 col-form-label">이메일</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" id="devEmail" name="devEmail" />
          </div>
        </div>
        <div class="form-group row">
          <label for="devGender" class="col-sm-2 col-form-label">성별</label>
          <div class="col-sm-10">
            <div class="form-check form-check-inline">
              <input type="radio" class="form-check-input" id="devGender0" name="devGender" value="M" />
              <label for="devGender0" class="form-check-label">남</label>
              <input type="radio" class="form-check-input" id="devGender1" name="devGender" value="F" />
              <label for="devGender1" class="form-check-label">여</label>
            </div>
          </div>
        </div>
        <div class="form-group row">
          <label class="col-sm-2 col-form-label">개발언어</label>
          <div class="col-sm-10">
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="checkbox" name="devLang"
              id="devLang0" value="Java"/>
              <label class="form-check-label" for="devLang0">Java</label>
            </div>	
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="checkbox" name="devLang"
              id="devLang1" value="C"/>
              <label class="form-check-label" for="devLang1">C</label>
            </div>	
            <div class="form-check form-check-inline">
              <input class="form-check-input" type="checkbox" name="devLang"
              id="devLang2" value="Javascript"/>
              <label class="form-check-label" for="devLang2">Javascript</label>
            </div>
          </div>
        </div>
        <div class="list-group">
          <button type="button" onclick="demo1();" id="demoFrmBtn" class="list-group-item list-group-item-action">HttpServlet 파라미터 이용 전송</button>

          <button type="button" onclick="demo2();" id="demoFrmBtn" class="list-group-item list-group-item-action">@RequestParam 파라미터 이용 전송</button>

          <button type="button" onclick="demo3();" id="demoFrmBtn" class="list-group-item list-group-item-action">@RequestParam 파라미터 Map객체 이용 전송</button>

          <button type="button" onclick="demo4();" id="demoFrmBtn" class="list-group-item list-group-item-action">VO(COMMAND객체) 이용 전송</button>

          <button type="button" onclick="insertDev();" id="demoFrmBtn" class="list-group-item list-group-item-action">dev등록</button>

        </div>
      </form>

    </div>
  </section>

  <jsp:include page="/WEB-INF/views/common/footer.jsp" />

