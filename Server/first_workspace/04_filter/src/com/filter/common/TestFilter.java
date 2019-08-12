package com.filter.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestFilter implements Filter {

  @Override
  public void destroy() {
    // TODO Auto-generated method stub

  }

//  class로 생성했으므로 web.xml에 filter직접 등록해야
  @Override
  public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
      throws IOException, ServletException {
    System.out.println("Filter 실행 : doFilter()");
    arg0.setCharacterEncoding("UTF-8");
    arg1.setContentType("text/html;charset=UTF-8");
    arg2.doFilter(arg0, arg1);
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {
    // TODO Auto-generated method stub
  }

}
