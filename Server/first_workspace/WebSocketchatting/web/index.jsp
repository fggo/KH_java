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
  <input type="text" id="userId" placeholder="아이디" />
  <input type="text" id="receiverId" placeholder="받는사람" />

  <div id="members"></div>

  <!-- 채팅결과창 -->
  <div id="result"></div>

  <!-- 입력창 -->
  <input type="text" id="message" placeholder="메시지 입력...">
  <button id="btn-send">메세지 전송</button>

  <!-- 파일 업로드 기능 -->
  <input type="file" id="up_file">
  <button id="upload">파일업로드</button>

  <script>
    //웹소켓을 생성
    // var socket = new WebSocket("ws://주소");
    // ws:localhost 로 하면 로컬 컴퓨터에서만 됨
    // ip를 적어야함
    // tomcat port # = 9090와 같음. 톰캣 서버포트 적으면 됨 9090
    // var socket = new WebSocket("ws://192.168.20.238:9191/<%=request.getContextPath() %>/chatting");
    // var socket = new WebSocket("ws://192.168.20.2:9090/<%=request.getContextPath() %>/chatting");
    var socket = new WebSocket("ws://localhost:9090/<%=request.getContextPath() %>/chatting");

    socket.onopen=function(e){
      console.log("onopen : " + e);
    }

    socket.onmessage=function(e){ 
      //server가 sendText() 메세지 전송한것 받음
      console.log("onmessage : " + e);
      console.log(e.data);
      console.log(typeof e.data); //객체형식의 string
      //string을 객체형식으로 바꿔줌
      var d = JSON.parse(e.data);
      console.log(d);
      if(d["flag"] == "msg"){
        console.log("'flag' is " + d["flag"]);
      }
      //parsing하기
      // var d = e.data.split(",");
      // if(d[d.length-1] == "members"){
      //   $('#members').html(d[1]);
      // }

      // var p = $("<p>").html(e.data);
      // $('#result').append(p);
    }

    socket.onclose

    $(function(){
      //파일 업로드
      $('#upload').click(function(){
        var file = $('#up_file')[0].files[0];
        //파일을 전송한다는 의미의 타입을 설정
        socket.binaryType = "arraybuffer";

        var reader = new FileReader();
        var rawData = new ArrayBuffer();
        reader.onload = function(e){
          rawData = e.target.result;
          socket.send(rawData);
        }
        reader.readAsArrayBuffer(file);
      });

      $('#btn-send').click(function(){
        //서버에 데이터 전송!
        //1. 문자로 전송!
        //server에서 Session.getUserProperties()로 받음
        //[0]:id, [1]msg, [2]no [3]msg(flag) 등을 서버로 보냄
        //구분자 ',' 넣어서 server에서 파싱가능하도록 함

        //userId,msg,room,flag,receiverId
        // socket.send($('#userid').val()+"," + $('#message').val() 
        //             + ",01,msg," + $('#receiverid').val());
        // socket.send("user01|" + $('#message').val() + "|01|file");

        //2. Object로 전송!
        //문자아닌, Object에 넣어서 보내는 방법도 가능!
        var msg = {
                  "userId" : $("#userId").val(),
                   "msg" : $('#message').val(),
                   "room" : "01",
                   "flag" : "msg",
                   "receiveId" : "",
                   }
        socket.send(JSON.stringify(msg)); //Object를 문자열로 보내줌
      });
    });

    // 이제 socket에 해당하는 서버를 생성! ->com.websocket.controller.ChattingServer
  </script>
  

</body>
</html>