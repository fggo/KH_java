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
  <h2>JSON으로 Data받아오기</h2>
  <button onclick="dataJson();">json 데이터 받기</button>
  <div id="area"></div>

  <script>
    function dataJson(){
      $.ajax({
        url: "<%=request.getContextPath() %>/jsonData",
        type: "POST",
        dataType: "json",
        success: function(data){
          // console.log(data);
          // console.log(typeof data);
          // for(var d in data){
          //   console.log(data[d]);
          //   console.log(typeof data[d]);
          //   var table = createTable(data);
          //   $('#area').html(table);
          // }
          var table = createListTable(data);
          $('#area').html(table);
        }
      });
    }

    function createListTable(source){
      var table=$("<table border=1>");
      var th=$("<tr>");
      var thDat="<th>번호</th><th>아이디</th><th>이름</th><th>주소</th>";
      th.html(thDat);
      table.append(th);
      for(var i=0;i<source.length;i++){//객체들
        var tr=$("<tr>");
        var td="<td>"+source[i]["userNo"]+"</td>";
        td+="<td>"+source[i]["userId"]+"</td>";
        td+="<td>"+source[i]["userName"]+"</td>";
        td+="<td>"+source[i]["userAddr"]+"</td>";
        tr.append(td);
        table.append(tr);
      }
        /* var th=$("<tr>");
        var td=$("<tr>");
        for(var data in source[i]){//객체선택
          if(i==0){
            var thDate=$("<th>").html(data);
            th.append(thDate);
          }
          var tdData=$("<td>").html(source[i][data]);
          td.append(tdData);
        }
        if(i==0) table.append(th);
        else {table.append(td);} */
      //}
      return table;
    }
    

    //json 객체(source)를 테이블 형식으로 만들어줌
    function createTable(source){
      var table = $('<table border=1>');
      var head = $('<tr>');
      for(var key in source){
        var headData =$('<th>').html(key);
        head.append(headData);
      }
      var row = $('<tr>');
      for(var key in source){
        var data = $('<td>').html(source[key]);
        row.append(data);
      }
      return table.append(head).append(row);
    }
  </script>

</body>
</html>