package com.listener.common;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

  private static int connectMember = 0;
  
  public static int getConnectMember() {
    return connectMember;
  }
  // ALT+S+V

  @Override
  public void sessionCreated(HttpSessionEvent se) {
    System.out.println("세션 생성!!");
    connectMember++;
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent se) {
    System.out.println("세션 소멸!!");
    //chrome, IE 열고 각각 생성,소멸하면 . 바뀌는 connectMember 출력됨
    //브라우저를 단순히 닫으면 세션소멸 안됨
    //windowClosed event 추가 해야함
    connectMember--;
    System.out.println("현재 세션 수 : " + getConnectMember());
  }

}
