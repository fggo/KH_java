package com.parameter.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LikeView
 */
@WebServlet("/likeview")
public class LikeView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//여기로 실제 redirect해서 넘어오는지 확인하기!
		System.out.println("likeview 입니다!");
		System.out.println(request.getAttribute("msg"));
//		response.getWriter().write("send likeview");

		String name = request.getParameter("name");
//		int age = Integer.parseInt(request.getParameter("age"));
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] foods = request.getParameterValues("foods");


//		증간 서블릿에서 보내준 값도 받기
//		request.getAttribute(key)
//		getAtrribute로 값을 받을 때는 반드시 형변환을 해줘야함!
		String msg = (String)request.getAttribute("msg"); // Object -> String
		//client에서 받은 값이 아님 servelet LikeTestDispathcer에서 가져온 메시지 data
		//servlet은 정적로딩이라 server reload해야하지만,
		//CONSOLE 메시지:
		//정보: Reloading Context with name [/02_secondWeb] has started
		//eclipse가 저절로 reload 대신 해줌
//		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		//클라이언트의 스트림을 가져옴
		PrintWriter out = response.getWriter();
		//스트림을 통해 소스코드를 전송
		out.write("<html>");
		out.write("<body>");
		out.write("<h1>" + msg+ "</h1>"); 
		out.write("<h1>당신의 이름은" + name + " 이네요.</h1>");
//		out.write("<h2>당신의 연세는 " + age + "살 입니다.</h2>");
		String choice = "";
		switch(color) {
			case "빨강": choice = "red"; break;
			case "파랑": choice = "blue"; break;
			case "노랑": choice = "yellow"; break;
			case "초록": choice = "green"; break;
			case "하늘": choice = "skyblue"; break;
		}
		String choAni = "";
		switch(animal) {
			case "강아지": choAni = "https://i.ytimg.com/vi/7NYaGOyJiCY/hqdefault.jpg"; break;
			case "고양이": choAni = "http://buildingontheword.org/wp-content/uploads/2016/08/cat.jpg"; break;
			case "병아리": choAni = "https://4.imimg.com/data4/MV/SH/MY-4527100/cub-500y-chicks1-250x250.jpg"; break;
			case "송아지": choAni = "https://cache.desktopnexus.com/thumbseg/2370/2370417-bigthumbnail.jpg"; break;
			case "기린": choAni = "https://upload.wikimedia.org/wikipedia/commons/9/9e/Giraffe_Mikumi_National_Park.jpg"; break;
		}
	
		out.write("<p style='color:" + choice+ "'>당신이 좋아하는 색은 " + color + "입니다.</p>");
		out.write("<p>당신이 좋아하는 동물은 <img src=" + choAni + " width='100px' height='100px'/>"
				+ animal + " 입니다.</p>");
		String foodlist="";
		for(String food : foods) foodlist += food + " ";
		out.write("<p>당신이 좋아하는 음식은 " + foodlist + " 입니다.</p>");
		out.write("</body>");
		out.write("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
