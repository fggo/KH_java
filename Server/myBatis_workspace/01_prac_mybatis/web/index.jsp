<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <!-- CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  <!-- JS -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container card my-5 col-md-8 jumbotron">
    <a href="javascript:;" id="toggleInsert">Insert Employee</a>
    <div id="insertEmp" class="container"></div>
    <a href="javascript:;" id="toggleSearch">Search Employee</a>
    <div id="searchEmp" class="container"></div>
  </div>

  <script>
    var isInsertToggled = "false";
    $(function(){
      $('#toggleInsert').click(function(){
        isInsertToggled = !isInsertToggled;
        if(isInsertToggled){
          $('#insertEmp').html("");
          return;
        }
        $.ajax({
          type: "POST",
          url: "${path }/insertEmp.do",
          dataType: "html",
          success: function(data){
            html = $('<div>').html(data);
            $('#insertEmp').html(html.find('div#insertFrm'));
          },
          error: function(request, status, error){
            alert("insertEmp.do ajax ERROR!");
          }
        });
      });
    });

    var isSeachToggled = "false";
    $(function(){
      $('#toggleSearch').click(function(){
        isSearchToggled = !isSearchToggled;
        if(isSearchToggled){
          $('#searchEmp').html("");
          return;
        }
        $.ajax({
          type: "POST",
          url: "${path }/searchEmp",
          dataType: "html",
          success: function(data){
            html = $('<div>').html(data);
            $('#searchEmp').html(html.find('div#searchFrm'));
          },
          error: function(request, status, error){
            alert("searchEmp ajax ERROR!");
          }
        });
      });
    });
  </script>
</body>
</html>