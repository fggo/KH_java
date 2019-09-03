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
  <title>xml파일 불러오기</title>
</head>
<body>
  <h2>xml파일 불러오기</h2>
  <button id="btn">실행</button>

  <div id="fiction">
    <h3>소설</h3>
    <table id="fictionInfo" border=1></table>
  </div>
  <div id="it">
    <h3>프로그래밍</h3>
    <table id="itInfo" border=1></table>
  </div>

  <script>
    $(function(){
      $('#btn').click(function(){
        $.ajax({
          url: "bookList.xml",
          type: "GET",
          dataType: "xml", //text xml json html
          success: function(data){
            console.log(data);
            //root태그를 불러옴
            var root = $(data).find(":root");
            console.log(root);
            var book = root.find("book");
            console.log(book);

            var fic = "<tr><th>제목</th><th>저자</th></tr>";
            var it = "<tr><th>제목</th><th>저자</th></tr>";

            book.each(function(){
              var html = "<tr><td>" + $(this).find("title").text()+ "</td>";
              html += "<td>" + $(this).find("author").text()+ "</td></tr>";

              if($(this).find("subject").text() =="소설"){
                fic += html;
              }
              if($(this).find("subject").text() =="프로그래밍"){
                it += html;
              }

              $('#fictionInfo').html(fic);
              $('#itInfo').html(it);
            });
          },
        });
      });
    });
  </script>
</body>
</html>