package com.filter.common.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyWrapper extends HttpServletRequestWrapper {

  //생성자를 설정을 해줘야 함
  public MyWrapper(HttpServletRequest request) {
    super(request);
  }

  @Override
  public String getParameter(String name) {
    String val = super.getParameter(name);
    val += "병승 우헬헬";
    return val;
  }
  
  //메소드 오버라이딩하여 request에서 사용하는 메소드를 커스터마이징 할 수 있음.
}
