package com.websocket.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import common.message.Message;
import common.message.MessageDecoder;
import common.message.MessageEncoder;

//client에서는 @Endpoint
@ServerEndpoint(value="/chatting",
        encoders = {MessageEncoder.class},
        decoders = {MessageDecoder.class} //OBJECT parsing
      )
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
  //연결 받은 session에게 다시 관리자: msg 보냄
  //@OnMessage
  //메소드 1개만 등록가능? overload안됨
  @OnMessage
  public void message(Session session, Message msg) {
    System.out.println(msg);
    try {
      session.getBasicRemote().sendObject(new Message("admin", "접속을 환영합니다!", "01", "msg", ""));

    } catch(IOException e) {
      e.printStackTrace();
    } catch(EncodeException e) {
      e.printStackTrace();
    }
  }
  
  //file전송 받기위한 
  //nio (network input output)
  @OnMessage(
      maxMessageSize=1024*1024*100) //100MB 까지 binarybuffer를 통한 파일 업로드 허용 
  public void message(ByteBuffer data, Session session) {
    System.out.println("데이터 전송했니?");
    System.out.println(data);
    System.out.println(session);
    
    //확장자 정하는법
    //1.파일업로드전 먼저 파일명 보내기(object형식으로) flag값으로 msg인지 file인지
    //static 멤버변수로

    //1.파일 업로드 전 파일명을 문자로 서버에 전송
    //2.전송된 파일명을 서버는 고용으로 쓸수있는 변수를 만들어서 보관(전역으로 써야함)
    //3.파일업로드, 업로드 로직에서 파일명지정시 보관된 변수로 불러옴
    //4.업로드가 끝나면 인원들에게 링크를 걸수있는 파일명을 다시 전송함.
    //5. 전송된 내용이 파일명이면 그 파일을 다운로드 할 수 있는 
    //서블릿으로 연결되는 링크태그를  만들여줌
    //6. 매핑된 서블릿에서 다운로드 로직을 구현함.
    try( BufferedOutputStream bos = new BufferedOutputStream(
                                             new FileOutputStream("C:\\Users\\user1\\KH\\KH_java\\Server\\file.jpg")
                                             );){
      bos.write(data.array());
    }catch(IOException e) {
      e.printStackTrace();
    }
  }

//  @OnMessage
//  public void message(Session session, String msg) {
//    System.out.println(msg);
//    //전체 session(연결된 컴퓨터들을) 확인하기
//    //session객체에서 연결되어 있는 session을 확인할 수 있는 메소드를 제공!
//    //openSession(); 반환형은 Set 방식(only stores unique session)
//    //클라이언트에서 new WebSocket으로 생성된 user들의 session들을 불러옴
//    //클라이언트한테 받은 메세지를 다시 전송
//    //session을 이용해서 각 클라이언트를 구분
//    Set<Session> set = session.getOpenSessions();
//    
//    //String 메세지를 파싱처리함.
//    String[] msgs = msg.split(","); //♧ 등 안쓰는 구분자
//    for(String s : msgs) {
//      System.out.println(s);
//    }
//    System.out.println(msgs[0]);
//    System.out.println(msgs[1]);
//    System.out.println(msgs[2]);
//    System.out.println(msgs[3]);
//
//    // session에 필요한 정보 넣기
//    // getUserProperties() : session에 필요한 정보를
//    // 저장하는 Map형식의 객체(id, pw 등등 저장): key-value형식으로 저장
//    session.getUserProperties().put("userId", msgs[0]);
//    session.getUserProperties().put("msg", msgs[1]);
//    session.getUserProperties().put("room", msgs[2]);
//    session.getUserProperties().put("flag", msgs[3]);
//    session.getUserProperties().put("receiveId", msgs[4]);
//
//
//    try {
//      //현재 나와 연결되어 있는 전체 session 불러오기!
//      for(Session s : set) {
//        String userId = (String)s.getUserProperties().get("userId");
//        String receiveId = (String)s.getUserProperties().get("receiveId");
//
//        //전체 접속회원 보냄
//        sendMember(session);
//
//        //user02한테만 보냄
////        if(userId!=null && userId.equals("user02")) {
//        if(userId!=null && receiveId!=null && userId.equals(receiveId)) {
//          s.getBasicRemote().sendText(userId + "," + msg + ",01,msg");
//        }
//        if(receiveId == null)
//          s.getBasicRemote().sendText(userId + "," + msg + ",01,msg");
//        
//        //같은 채팅룸에있는
//        //if (room이 같은 방이면) sendText
//        //flag: 01234 받는사람... 보내는사람 정보 보냄
//      }
//    } catch(IOException e) {
//      e.printStackTrace();
//    }
//  }
//  private void sendMember(Session session) {
//    String members = "";
//    for(Session s: session.getOpenSessions()) {
//      members += (String)s.getUserProperties().get("userId") + "§";
//    }
//
//    try {
//      //admin, members,방번호,flag
//      session.getBasicRemote()
//        .sendText("admin," + members + ",01,members");
//    }catch(IOException e) {
//      e.printStackTrace();
//    }
//  }
}
