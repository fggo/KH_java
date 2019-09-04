<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <!-- CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
  <!-- JS -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
  <h2>자동완성</h2>
  <input type="text" name="searchId" id="searchId" list="autoData"/>
  <datalist id="autoData"></datalist>

  <script>
    $(function(){
      $("#searchId").keyup(function(){
        $.ajax({
          url:"<%=request.getContextPath()%>/ajax/autoComplete.do",
          type:"POST",
          // data:response 응답을 받아서 success data로 받음
          data:{key:$(this).val()}, //$(this) == $('#searchId')
          dataType:"html",
          success:function(data){
            // $("#autoData").html(data); //List<String>으로 받을때만 적용 csv및 다른 dataType은 안됨
            $('#autoData').html("");
            var datas = data.split(",");
            for(var i =0; i<datas.length; i++){
              var option = $('<option>').attr("value", datas[i]).html(datas[i]);
              $('#autoData').append(option);
            }
          }
        });
        
      });
    });
  </script>

</body>  