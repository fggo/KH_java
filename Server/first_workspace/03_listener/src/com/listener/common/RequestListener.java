package com.listener.common;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestListener
 *
 */
@WebListener
public class RequestListener implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public RequestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent arg0)  { 
      System.out.println("client 요청처리 완료");
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent arg0)  { 
      System.out.println("client 요청");
      String path = arg0.getServletRequest().getServletContext().getContextPath();
      System.out.println(path);

      //request 생성할때 encoding을 UTF-8 설정하게 함
      try {
        arg0.getServletRequest().setCharacterEncoding("UTF-8");
      } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
	
}
