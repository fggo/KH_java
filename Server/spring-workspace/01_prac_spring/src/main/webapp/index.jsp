<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
  <jsp:param name="pageTitle" value="Homepage" />
</jsp:include>

  <section id="content">
    <a id="toggleInsertBtn" href="javascript:void(0);">insert Employee</a>
    <div id="insertArea" class="container"></div>

  </section>

  <script>
    var insertToggled = false;
    var searchToggled = false;
    var updateToggled = false;
    var deleteToggled = false;

    $(function(){
      $('#toggleInsertBtn').click(function(e){

        if(insertToggled)
          $('#insertArea').html("");
        else{
          $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath }/insertEmp.do",
            dataType: "html",
            success: function(data){
              html = $('<div>').html(data);

              $('#insertArea').html(html.find("div#insertFrm"));
            },
            error: function(request, status, error){
              console.log(error);
              alert("insert ajax ERROR!");
            }
          });
        }

        insertToggled = !insertToggled;
      });
    });
  </script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
