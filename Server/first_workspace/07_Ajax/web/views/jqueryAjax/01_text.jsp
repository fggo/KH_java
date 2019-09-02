<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>

  <!-- JS -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

  </head>
  <body>
      <h2>jQueryAjax - text파일 - </h2>
      <button id="btn">test.txt 내용 불러오기</button>
      <div id="content"></div>
      <script>
        $(function(){
          $('#btn').click(function(){
            //Ajax요청하기
            //jquery방식으로 요청할때는 %.ajax()함수를 호출하고,
            //호출시에 객체 형식으로 속성값을 초기화해 주면 됨.
            $.ajax({
              url: "test.txt", //요청주소 /url/to/test.txt
              type: "GET", //요청방식
              dataType: "text", //응답데이터 형
              // dataType 종류: text(csv), html, script, xml, json
              success: function(data){
                console.log(data);
                var tag = $("<h3>").html(data).css("color", "blue");
                $('#content').append(tag);
              },
              error: function(request, status, error){
                console.log("error 함수 실행!");
                console.log(request);
                console.log(status);
                console.log(error);
              },
            });
          });
        });
      </script>

      <h2>jqueryAjax - html</h2>
      <button id="btn2">서버에서 html 문서 받기</button>
      <div id="content2"></div>
      <script>
        $(function(){
          $("#btn2").click(function(){
            $.ajax({
              url: "<%=request.getContextPath() %>/ajax/test.do",
              type: "GET",
              dataType: "html", //jsp일때 dataType: html
              success: function(data){
                console.log(data);
                $('#content2').html(data);
              }
            });
          });
        });
      </script>

      <h2>csv 방식으로 불러오기</h2>
      <!-- | == \n -->
      csv : 이름,유병승,나이,19|이름,유병승,나이,29
      <button id='btn3'>csv가져오기</button>
      <div id='content3'></div>
      <script>
        $(function(){
          $('#btn3').click(function(){
            $.ajax({
              //요청주소 test3.do
              //응답데이터 text
              //방식: get
              //결과는 content3에 출력
              url: "<%=request.getContextPath() %>/test3.do",
              dataType: "text",
              type: "GET",
              success: function(data){
                // $('#content3').html(data);
                // 데이터별로 구분하기 위한 기준값을 찾음!
                var members = data.split("\n"); //배열
                console.log(members);
                var table = $("<table>");
                for(var i =0; i<members.length; i++){
                  var member = members[i].split(",");
                  var tr = $('<tr>');
                  var name = $('<td>').html(member[0]);
                  var phone = $('<td>').html(member[1]);
                  var profile = $('<td>').html(member[2]);
                  tr.append(profile).append(name).append(phone);
                  table.append(tr);
                }
                $('#content3').html(table);
              },
            });
          });
        });
      </script>

  </body>