<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="path" value="${pageContext.request.contextPath}" />

<jsp:include page="/WEB-INF/views/common/header.jsp">
  <jsp:param name="pageTitle" value="dev검색결과" />
</jsp:include>

  <div class="container card my-5 col-md-10 jumbotron">
    <table class="table">
      <tr>
        <th scope="col">번호</th>
        <th scope="col">이름</th>
        <th scope="col">나이</th>
        <th scope="col">이메일</th>
        <th scope="col">성별</th>
        <th scope="col">개발가능언어</th>
      </tr>

      내용구성
      <c:forEach var="dev" items="${devList }" varStatus='w'>
        <tr>
          <td class="one"><c:out value="${dev.devNo}" /></td>
          <td class="two"><c:out value="${dev.devName}" /></td>
          <td class="three"><c:out value="${dev.devAge}" /></td>
          <td class="four"><c:out value="${dev.devEmail}" /></td>
          <td class="five"><c:out value="${dev.devGender=='M'?'남':'여'}" /></td>
          <td class="six">
            <!-- varstatus (index[0 1 2 3...] count first last) -->
            <c:forEach var="lang" items="${dev.devLang }" varStatus='v'>
              ${v.index!=0? ",": ""}${lang}
            </c:forEach>
          </td>
          <td>
            <button type="button" class="btn btn-outline-info" id="updateBtn${w.index}" data-toggle="modal"
             data-target="#myUpdateModal" data-whatever="@mdo">수정</button>
          </td>
          <td>
            <button type="button" class="btn btn-outline-danger" id="deleteBtn${w.index}">삭제</button>
          </td>
        </tr>
        
        <script>
          $(function(){
            $('#updateBtn${w.index}').click(function(){
              var modalUpdateBody = $('#modalUpdateDialog');
              
              var devNo = $(this).closest('tr').children('td.one').text();
              var devName = $(this).closest('tr').children('td.two').text();
              var devAge = $(this).closest('tr').children('td.three').text();
              var devEmail = $(this).closest('tr').children('td.four').text();
              var devGender = $(this).closest('tr').children('td.five').text();
              var devLang = $(this).closest('tr').children('td.six').text();
              console.log(devNo + devName + devAge + devEmail + devGender + devLang);
              $.ajax({
                type: "POST",
                url: "${path }/demo/updateDev.do",
                dataType: "html",
                data:{"devNo": devNo, "devName": devName, "devAge": devAge,
                      "devEmail": devEmail, "devGender": devGender, "devLang": devLang },
                success: function(data){
                  html = $("<div>").html(data);
                  modalUpdateBody.html(html.find("div#update-container"));
                },
                error: function(error){
                  alert(error);
                },
              });
            });

            $('#deleteBtn${w.index}').click(function(){
              if(!confirm("are you sure to delete"))
                return;
              var devNo = $(this).closest('tr').children('td.one').text();
              $.ajax({
                type: "POST",
                url: "${path }/demo/deleteDev.do",
                data:{"devNo": devNo},
                success: function(data){
                  alert("successfully deleted");
                  window.location.reload()
                },
                error: function(error){
                  alert(error);
                },
              });
            });

          });
        </script>

      </c:forEach>

    </table>
  </div>

  <div class="modal fade" id="myUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myUpdateModalLabel"
       aria-hidden="true">
    <div class="modal-dialog" role="document" id="modalUpdateDialog"></div>
  </div>

  <script>
    $('#myUpdateModal').on('shown.bs.modal', function () {
      $('#devName').trigger('focus')
      var temp = $('#devName').val();
      $('#devName').val('');
      $('#devName').val(temp);
    })
  </script>


<jsp:include page="/WEB-INF/views/common/footer.jsp" />
