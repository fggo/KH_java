<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="path" value="${pageContext.request.contextPath}" />

<jsp:include page="/WEB-INF/views/common/header.jsp">
  <jsp:param name="pageTitle" value="UpdateDev" />
</jsp:include>

  <style>
    div#update-container{
      width: 40%;
      padding: 15px;
      margin: 0 auto;
      border: 1px solid limegreen;
      border-radius: 10px;
    }
  </style>

  <!-- views 밑에 demo/demo.jsp 생성 -->
  <section id="content">
    <div class="modal-content" id="update-container">
      <div class="modal-header">
        <h5 class="modal-title" id="myUpdateModalLabel">Update Dev</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <!-- <h2>Parameter Test</h2> -->
        <form action="" id="updateFrm" method="POST">
          <div class="form-group row my-0 py-0">
            <label for="devNo" class="col-sm-2 col-form-label">번호</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="devNo" name="devNo" value="${dev.devNo }" readonly/>
            </div>
          </div>
          <div class="form-group row my-0 py-0">
            <label for="devName" class="col-sm-2 col-form-label">이름</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="devName" name="devName" value="${dev.devName }" />
            </div>
          </div>
          <div class="form-group row my-0 py-0">
            <label for="devAge" class="col-sm-2 col-form-label">나이</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="devAge" name="devAge" value="${dev.devAge }" />
            </div>
          </div>
          <div class="form-group row my-0 py-0">
            <label for="devEmail" class="col-sm-2 col-form-label">이메일</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="devEmail" name="devEmail" value="${dev.devEmail }" />
            </div>
          </div>
          <div class="form-group row my-0 py-0">
            <label for="devGender" class="col-sm-2 col-form-label">성별</label>
            <div class="col-sm-10">
              <div class="form-check form-check-inline">
                <label class="form-check-label mr-3">
                  <input type="radio" class="form-check-input" id="devGender0" name="devGender" value="M"
                    <c:if test="${dev.devGender == '남'}">checked</c:if> />남
                </label>
                <label class="form-check-label">
                  <input type="radio" class="form-check-input" id="devGender1" name="devGender" value="F"
                    <c:if test="${dev.devGender == '여'}">checked</c:if> />여
                </label>
              </div>
            </div>
          </div>
          <div class="form-group row my-0 py-0">

            <c:set var="langs" value="${fn:join(dev.devLang,' ')}" />

            <label class="col-sm-2 col-form-label">개발언어</label>
            <div class="col-sm-10">
              <div class="form-check form-check-inline">
                <label class="form-check-label">
                  <input class="form-check-input" type="checkbox" name="devLang" id="devLang0" value="Java"
                    ${(fn:indexOf(langs, 'Java')!=-1 && fn:indexOf(langs, 'Java')!= fn:indexOf(langs, 'Javascript'))? 'checked':''} />Java
                </label>
              </div>
              <div class="form-check form-check-inline">
                <label class="form-check-label">
                  <input class="form-check-input" type="checkbox" name="devLang" id="devLang1" value="C"
                    ${fn:contains(langs, 'C')? 'checked':'' } />C
                </label>
              </div>	
              <div class="form-check form-check-inline">
                <label class="form-check-label">
                  <input class="form-check-input" type="checkbox" name="devLang" id="devLang2" value="Javascript"
                    ${fn:contains(langs, 'Javascript')? 'checked':''} />Javascript
                </label>
              </div>
            </div>
          </div>

        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" id="updateFrmBtn" class="btn btn-primary">Confirm</button>

        <script>
          $(function(){
            $('#updateFrmBtn').click(function(){
              var formData = $('form#updateFrm').serialize();
              console.log(formData);
              $.ajax({
                type:"POST",
                url:"${path }/demo/updateDevEnd.do",
                data: formData,
                success: function(data){
                  alert("update success! ");
                  window.location.reload();
                },
                error: function(data){
                  alert("error! " + data);
                },
              });
            });

          });
        </script>

      </div>
    </div>
  </section>


<jsp:include page="/WEB-INF/views/common/footer.jsp" />
