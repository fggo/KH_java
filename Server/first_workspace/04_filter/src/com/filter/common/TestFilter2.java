package com.filter.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.filter.common.wrapper.MyWrapper;

/**
 * Servlet Filter implementation class TestFilter2
 */
//@WebFilter("/*")
@WebFilter(servletNames= {"testFilter",
                          "firstServlet",
                         })
public class TestFilter2 implements Filter {

    /**
     * Default constructor. 
     */
    public TestFilter2() {
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
	  System.out.println("testFilter2 실행");
	  
	  MyWrapper my = new MyWrapper((HttpServletRequest)request);
      chain.doFilter(my, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
