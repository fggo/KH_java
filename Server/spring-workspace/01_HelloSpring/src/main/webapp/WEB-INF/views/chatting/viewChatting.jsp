<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
  <style>
    html, body {
    padding: 0px;
    margin: 0px;
    font-family: "Arial", "Helvetica", sans-serif;
  }

  #loading_state {
    position: absolute;
    top: 45%;
    left: 0px;
    width: 100%;
    font-size: 20px;
    text-align: center;
  }

  #open_call_state {
    display: none;
  }

  #local_video {
    position: absolute;
    top: 10px;
    left: 10px;
    width: 160px;
    height: 120px;
    background: #333333;
  }

  #remote_video {
    position: absolute;
    top: 0px;
    left: 0px;
    width: 1024px;
    height: 768px;
    background: #999999;
  }
  #membercontainer{
    position: absolute;
    top:20px;
    left:70%;
  }

  #membercontainer>ul{
    list-style-type:none;
  }
  #membercontainer>ul>li>h3{
    cursor:pointer;
  }
  </style>
</head>
<body onload="start()">
      <div id="membercontainer">
         <ul class="members">
         </ul>
      </div>
   <div id="loading_state">
   </div>
   <div id="open_call_state">
      <video id="remote_video" controls></video>
      <video id="local_video"></video>
      <div id="membercontainer" class="jumbotron container">
         <ul class="members">
         </ul>
      </div>
   </div>
</body>
</html>

  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>


  <script>
    //web rtc 운영에 필요한 6개의 변수를 지정
    var webrtc_capable = true; //브라우저가 webrtc를 지원하는지 여부 (https://webrtc.org)
    var rtc_peer_connection = null; //peer간의 통신을 할 수 있게 하는 객체
    var rtc_session_description = null; //webrtc에서 유지하는 session 객체
    var get_user_media = null;  //현재 브라우저를 실행하는 컴퓨터의 video, audio 디바이스를 가져오는 것
                                //현재 하드웨어가 가지고 있는 device를 가져오는것
    var connect_stream_to_src = null; //video관련 stream을 video 태그에 연결
    //<video src="스트림">  //스트림과 연결
    var stun_server = "stun.l.google.com:19302";
    //p2p 통신을 위해 서로간의 사설 IP주소를 확인시켜주는 서버

    //선언한 변수에 값 세팅하기!!
    if(navigator.getUserMedia){ //웹 표준 방식으로 접근
      rtc_peer_connection = RTCPeerConnection; //브라우저가 알아서 넣어줌
      rtc_session_description = RTCSessionDescription; //session 브라우저가 미리 구현한것을 받아서 씀
      get_user_media = navigator.getUserMedia.bind(navigator); //로컬의 미디어 데이터를 불러옴
      connect_stream_to_src = function(media_stream, media_element){
        media_element.srcObject = media_Stream; //영상을 전송하는 스트림
        //<video>태그에 src속성을 넣는 것
        media_element.play(); //video 태그 실행
      };
    }
    else if(navigator.mozGetUserMedia){ //firefox browser
      rtc_peer_connection = mozRTCPeerConnection; //브라우저가 알아서 넣어줌
      rtc_session_description = mozRTCSessionDescription; //session 브라우저가 미리 구현한것을 받아서 씀
      get_user_media = navigator.mozGetUserMedia.bind(navigator); //로컬의 미디어 데이터를 불러옴
      connect_stream_to_src = function(media_stream, media_element){
        media_element.mozSrcObject = media_Stream; //영상을 전송하는 스트림
        //<video>태그에 src속성을 넣는 것
        media_element.play(); //video 태그 실행
      };
      stun_server = "74.125.31.127:19302" //firefox 공개 stun서버 DNS 제공하지 않은(문자 주소 X)
    }
    else if(navigator.webkitGerUserMedia){ //chrome browser
      rtc_peer_connection = webkitRTCPeerConnection; //브라우저가 알아서 넣어줌
      rtc_session_description = RTCSessionDescription; //session 브라우저가 미리 구현한것을 받아서 씀
      get_user_media = navigator.webkitGetUserMedia.bind(navigator); //로컬의 미디어 데이터를 불러옴
      connect_stream_to_src = function(media_stream, media_element){
        media_element.src = webkitURL.createObjectURL(media_Stream); //영상을 전송하는 스트림
        //<video>태그에 src속성을 넣는 것
        // media_element.play(); //video 태그 실행
      };
    }
    else{
      alert("이 브라우저는 화상채팅이 불가능합니다. 다른 브라우저로 접속하세요!");
      webrtc_capable = false;
    }
  </script> 
  <!-- 여기까지 webRTC를 적용하기 위한 기본 설정 -->

  <!-- 실제화상 통신을 구현하는 script -->
  <script>
    var call_token = "${loginMember.userId}"; //사용자를 구분하기 위한 변수
    var signaling_server; //화상채팅시 정보를 주고받게할 서버 *websocket으로 활용! 이게 가장좋음
    var peer_connect; //실질적인 연결 정보를 저장할 객체

    //페이지가 로드되면 변수들을 세팅하는 함수구현
    //peer_connect, signalingserver, 페이지에 필요한 정보를 설정

    function start(){
      peer_connect = new rtc_peer_connection({
        "iceServers": [
          {
            "url": "stun:" + stun_server //stun서버는 주소를 줌
          }

        ],

      });
      //p2p간의 접속할 수 있는 경로
      peer_connect.onicecandiate = function(ice_event){
        if(ice_event.candiate){
          signaling_server.send(JSON.stringify({
            token: call_token,
            type: "new_ice_candidate",
            candidate: ice_event.candiate
          }));
        }

      };

      //자신(local)의 영상을 브라우저에 세팅
      setup_video(); 
      //원격peer(채팅할 상대방)에 영상을 세팅
      peer_connect.onaddstream = function(event){
        connect_stream_to_src(event.stream, document.getElementById('remote_video'));
        $('#loading_state').hide();
        $('#open_call_State').show();
      }

      //메세지를 주고받게 해주는 서버등록(websocket)
      //ws : http //wss : https
      // signaling_server = new WebSocket("ws://192.168.120.164:9090/spring/viewChatting");
      // signaling_server = new WebSocket("wss://192.168.120.164:8443/spring/viewChatting");
      signaling_server = new WebSocket("wss://192.168.120.164:8443/spring/viewChatting");
      //8443 은 디폴트 포트라서 빼줘도 됨 (port forward 할때,)

      //--시그널링 서버설정 onmessage 함수를 등록
      signaling_server.onopen = function(){
        //메세지 처리함수
        signaling_server.onmessage = caller_signal_handler;
        //접속한 것을 시그널링서버에 알림
        signaling_server.send(JSON.stringify({
          token: call_token,
          type: "join"
        }));
      }
      document.title = "연결대기중";
      $('#loading_state').html("영상통화 대기중...");
    } //기본환경설정끝

    var connected_true; //요청이 왔는지 확인하는 flag

    //signalingserver 에서 온 메시지 처리함수 설정
    function caller_signal_handler(event){
      var signal = JSON.parse(event.data); // 서버에서 보낸 메시지 파싱
      if(signal.type == "callee_arrived"){ //화상연결요청이 들어왔을때 처리
        //서로 연결을 위한 sdp객체를 생성해서 전송
        //sdp(description) 미디어설정값이 들어가 있음, 해상도, 코딩값.. 등등
        //createOffer() 상대방에게 연결하기 위한 값을 생성하고 생성이 정상적으로 이뤄지면
        //첫번째 매개변수에 함수를 실행함, 정상적으로 생성되지 않으면 error가 발생하면 두번쨰 함수를 실행함,
        //정상적으로 생성되지 않으면, error가발생하면 두번째 함수를 실행 * 두가지 다 callback함수
        peer_connect.createOffer(new_description_created, log_error);

      } else if(signal.type == "new_ice_candidate") {
        peer_conect.addIceCandidate(new RTCIceCandidate(signal.candidate));

      } else if (signal.type == "new_description"){ //연결요청을 받아서 offer로 new desciption넘김. sdp연결정보를 바탕으로 연결함. p2p간 연결하는 로직
        peer_connect.setRemoteDescription(new rtc_session_description(
          signal.sdp, function(){ //성공에 대한 callback함수 연결되면 실행하는 함수
            if(peer_connect.remoteDescription.type == "answer"){
              if(connected){
                if(confirm("화상채팅 요청이 들어왔습니다. 허용하시겠습니까?")){
                  sendArrived();
                }
                connected = false;
              }
            }
            //description이 도착했을때, 화상채팅 하시겠습니까 offer가 들어왔을때, 응답하는 로직
            if(peer_connect.remoteDescription.type == "offer"){
              peer_connect.createAnswer(new_description_created, function(){});
            }
          }
        ));
      } else if(signal.type == "member"){ // 현재 접속자를 출력
        var membercontainer = $('.members');
        membercontainer.html("");
        for(var i =0; i<signal.members.length; i++){
          var li = $('<li>');
          var h =  $('<h3>').html(signal.members[i]).css("color", "gray");
            if(call_token != signal.members[i]){
              h.css('color', 'green');
              h.click(function(){
                if(confirm($(this).html() + "과 연결 하시겠습니까?")){
                  sendArrived();
                }
              });
            }
            li.html(h);
            membercontainer.append(li);
        }
      }
      caller_signal_handler
    } //message handler (caller_signal_handler) 끝


    //description, sdp를 만들어주는 함수
    function new_description_created(description){
      peer_connection.setLocalDescription(description, function(){
        signaling_server.send(JSON.stringify({
          token: call_token,
          type: "new_description",
          sdp:description,
        }));
      });

    }

    //stream 처리하기
    function setup_video(){
      get_user_media({
        "audio" : true,
        "video" : true, //로컬에 있는 브라우저에서 가져옴 //브라우저가 컴퓨터의 sound, video디바이스를 가져오기

      }, function(local_stream){
        //로컬 스트림연결
        connect_stream_to_src(local_stream, document.getElementById('local_video'));
        //peer_connect에 로컬스트림을 추가
        peer_connect.addStream(local_stream);
      }, log_error)
    }
    function log_error(error){
      console.log(error);
    }
    function sendArrived(){
      signaling_server.send(JSON.stringify({
        token:call_token,
        type:"callee_arrived",
      }))
    }


    /* ERROR : WebSocket이 없어서 에러: Spring webSocket사용+ jackson(JSON처리) viewChatting.do:181 WebSocket connection to 'wss://192.168.120.164/spring/viewChatting' failed: Error in connection establishment: net::ERR_CONNECTION_REFUSED
start @ viewChatting.do:181 */
  </script>

<jsp:include page="/WEB-INF/views/common/footer.jsp" />
