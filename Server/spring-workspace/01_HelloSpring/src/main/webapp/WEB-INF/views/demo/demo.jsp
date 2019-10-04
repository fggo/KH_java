<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
  div#demo-container{
    width: 40%;
    padding: 15px;
    margin: 0 auto;
    border: 1px solid limegreen;
    border-radius: 10px;
  }
</style>

<c:set var="path" value="${pageContext.request.contextPath}" />

<jsp:include page="/WEB-INF/views/common/header.jsp">
<jsp:param name="pageTitle" value="DemoPage" />
</jsp:include>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/ >


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
        <label for="devLang" class="col-sm-2 col-form-label">언어</label>
        <div class="col-sm-10">
          <div class="form-check form-check-inline">
            <input type="radio" class="form-check-input" id="devLang0" name="devLang" value="Java" />
            <label for="devLang0" class="form-check-label">Java</label>
            <input type="radio" class="form-check-input" id="devLang1" name="devLang" value="C" />
            <label for="devLang1" class="form-check-label">C</label>
            <input type="radio" class="form-check-input" id="devLang2" name="devLang" value="Javascript" />
            <label for="devLang2" class="form-check-label">Javascript</label>
          </div>
        </div>
      </div>
      <div class="list-group">
        <button type="button" onclick="demo1();" class="list-group-item list-group-item-action">HttpServlet 파라미터 이용 전송</button>

      </div>
    </form>

  </div>
</section>

<script>
  function demo1(){
    $('#devFrm').attr({"action" : "${path }/demo/demo1.do" } );
    $('#devFrm').submit();
  }
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />

