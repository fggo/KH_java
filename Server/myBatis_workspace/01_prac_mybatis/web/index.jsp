<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <a href="javascript:;" id="toggleInsertBtn">Insert Employee</a>
    <div id="insertArea" class="container"></div>

    <a href="javascript:;" id="toggleSearchBtn">Search Employee</a>
    <div id="searchArea" class="container"></div>

  </div>

  <script>
    var insertToggled = false;
    var searchToggled = false;
    var updateToggled = false;
    var deleteToggled = false;

    $(function(){

      $('#toggleInsertBtn').click(function(){
        if(insertToggled)
          $('#insertArea').html("");
        else{
          $.ajax({
            type: "POST",
            url: "${path }/insertEmp.do",
            dataType: "html",
            success: function(data){
              html = $('<div>').html(data);
              $('#insertArea').html(html.find('div#insertFrm'));
            },
            error: function(request, status, error){
              alert("insertEmp.do ajax ERROR!");
            }
          });
        }
        insertToggled = !insertToggled;

      });

      $('#toggleSearchBtn').click(function(){
        if(searchToggled)
          $('#searchArea').html("");
        else{
          $.ajax({
            type: "POST",
            url: "${path }/searchEmp",
            dataType: "html",
            success: function(data){
              html = $('<div>').html(data);
              $('#searchArea').html(html.find('div#searchFrm'));
            },
            error: function(request, status, error){
              alert("searchEmp ajax ERROR!");
            }
          });
        }
        searchToggled = !searchToggled;

      });

    });

  </script>

</body>
</html>