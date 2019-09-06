package com.websocket.controller;

import java.io.IOException;
import java.util.Set;

import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chatting") //client에서는 @Endpoint
public class ChattingServer {
  //채팅 이벤트 처리
  
  /*
   * client가 웹소켓서버에 연결요청을 하면 실행되는 메소드
   * new WebSocket()을 client jsp에서 생성할때!
   */
  @OnOpen
  public void open(Session session, EndpointConfig config) {
    System.out.println("접속성공" + session.getId());
    //unique session id: session.getId();
    //F5 refresh 마다 session 값 바뀜!
  }
  
  //전송오는 데이터를 받는 메소드 설정
  //메시지 보낸 사람의 session이 들어옴
  //@OnMessage
  @OnMessage
  public void message(Session session, String msg) {
    System.out.println(msg);
    //클라이언트한테 받은 메세지를 다시 전송
    //session을 이용해서 각 클라이언트를 구분
    try {
      //현재 연결되어 있는 전체 session 불러오기!
      for(Session s : session.getOpenSessions()) {
        s.getBasicRemote().sendText("관리자: " + msg);
      }
      
      //session.getBasicRemote().sendText("관리자: " + msg);
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}
