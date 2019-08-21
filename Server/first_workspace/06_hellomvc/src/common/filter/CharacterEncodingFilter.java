package common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class CharFilter
 */
//@WebFilter(servletNames= {"enrollEnd", }) //memberEnroll.jsp만 필터를 거치도록
//@WebFilter("/memberEnrollEnd") //memberEnroll.jsp만 필터를 거치도록
@WebFilter("/*") //모든파일이 이 필터를 거치도록
public class CharacterEncodingFilter implements Filter {
    /**
     * Default constructor. 
     */
    public CharacterEncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      System.out.println("Filter 실행 : doFilter()");
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      //response.setContentType("text/html;charset=UTF-8"); //이렇게 하면 모든 html css등에 다 보내버림
      chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
