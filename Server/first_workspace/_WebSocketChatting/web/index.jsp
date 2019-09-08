<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
  <!-- JS -->
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  <title>채팅페이지</title>
</head>
<body>
  <!-- 채팅창 -->
  <div id="result"></div>
  <!-- 입력창 -->
  <input type="text" id="message">

  <button id="btn-send">전송</button>

  <script>
    //웹소켓을 생성
    // var socket = new WebSocket("ws://주소");
    // ws:localhost 로 하면 로컬 컴퓨터에서만 됨
    // ip를 적어야함
    // tomcat port # = 9090와 같음. 톰캣 서버포트 적으면 됨 9090
    var socket = new WebSocket("ws://192.168.20.238:9191/<%=request.getContextPath() %>/chatting");
    // var socket = new WebSocket("ws://192.168.20.2:9090/<%=request.getContextPath() %>/chatting");
    // var socket = new WebSocket("ws://localhost:9090/<%=request.getContextPath() %>/chatting");
    socket.onopen=function(e){
      console.log(e);
    }
    socket.onmessage=function(e){ 
      //server가 sendText() 메세지 전송
      console.log(e);
      console.log(e.data);
      var p = $("<p>").html(e.data);
      $('#result').append(p);
    }

    socket.onclose

    $(function(){
      $('#btn-send').click(function(){
        //서버에 데이터 전송!
        //문자로 전송!
        socket.send($('#message').val());
      });
    });

    // 이제 socket에 해당하는 서버를 생성! ->com.websocket.controller.ChattingServer
  </script>
  

</body>
</html>