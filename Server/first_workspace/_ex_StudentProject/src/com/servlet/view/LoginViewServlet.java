package com.servlet.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.model.vo.Member;

// THIS HAS BEEN REPLACED BY loginView.jsp!!!!!!!!!!
/**
 * Servlet implementation class LogininViewServlet
 */
@WebServlet("/loginView")
public class LoginViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  Member m=(Member)request.getAttribute("member");
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out=response.getWriter();
      
      out.print("<html>");
      out.print("<head>");
      out.print("<link rel='stylesheet' type='text/css' href='css/layout1.css'>");
      out.print("<link rel='stylesheet' type='text/css' href='css/register.css'>");
      out.print("<link href='https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap' rel='stylesheet'>");
      out.print("</head>");
      out.print("<body>");
      out.print("<header>");
      out.print("<div class='head'>");
      out.print("<div class='img center'>");
      out.print("<img src='images/moo.png' width='150px' height='150px'>");
      out.print("</div>");
      out.print("<div class='login'>");
      out.print("<table>");
      out.print("<tr>");
      out.print("<td>"+m.getMemberName()+"님 환영합니다.</td>");
      out.print("</tr>");
      out.print("<tr>");
      out.print("<td><button onclick='logout();'>로그아웃</button></td>");
      out.print("</tr>");
      out.print("</table>");
      out.print("</div>");
      out.print("</header>");
      out.print("<article>");
      out.print("<h1>취미</h1>");
      out.print("<ol>");
      String[] hobbys = m.getHobby().split(",");
      for(String h : hobbys)
          out.print("<li>"+h.trim()+"</li>");
      out.print("</ol>");
      out.print("</article>");
      out.print("</body>");
      out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
