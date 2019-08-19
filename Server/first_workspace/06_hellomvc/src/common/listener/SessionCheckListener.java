package common.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCheckListener
 *
 */
@WebListener
public class SessionCheckListener implements HttpSessionListener, HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public SessionCheckListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
//      f12-application-JSession id assigned!!!
      //아이디가 부여됐을때
      System.out.println("session 생성!");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
      System.out.println("session 소멸!");
    }

  @Override
  public void attributeAdded(HttpSessionBindingEvent event) {
    //session setAttribute 했을때: 따라서 로그아웃하고 단순히 세션 id 바뀌는건 이 이벤트가 발생 안된!
      System.out.println("Attr : session 생성!");
    
  }

  @Override
  public void attributeRemoved(HttpSessionBindingEvent event) {
      System.out.println("Attr : session 소멸!");
    
  }

  @Override
  public void attributeReplaced(HttpSessionBindingEvent event) {
    // TODO Auto-generated method stub
  }
	
}
