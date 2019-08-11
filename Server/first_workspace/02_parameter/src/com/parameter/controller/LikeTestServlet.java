package com.parameter.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LikeTestServlet
 */
@WebServlet("/like.do")
public class LikeTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1.기본 값을 받아오기 : getParameter("key");
		String name = request.getParameter("name");
		// 브라우저에서 전송되는 데이터를 받을때 getParameter로 받을때
		// 반환값을 String
		int age =Integer.parseInt(request.getParameter("age"));
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
//		String foods = request.getParameter("foods"); //첫번째만 가져옴
		String[] foods = request.getParameterValues("foods");

		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("색상 : " + color);
		System.out.println("동물 : " + animal);
		System.out.print("음식 : " );
		for(String food : foods)
			System.out.print(food + " ");
		System.out.println();

		//request 객체를 이용해서 key값만 받아올수 있음
		System.out.println("===== 키 값을 확인 =====");
		Enumeration<String> em = request.getParameterNames();
		while(em.hasMoreElements()) {
			System.out.println(em.nextElement());
		}
		
		//3. map형식으로 모든값을 받아오기
		Map<String, String[]> map = request.getParameterMap();
		Set<Map.Entry<String, String[]>> set = map.entrySet();
		Iterator<Map.Entry<String, String[]>> it = set.iterator();

		while(it.hasNext()) {
			Map.Entry<String, String[]> e = it.next();
			System.out.println(e.getKey());
			for(String val : e.getValue()) {
				System.out.println(val);
			}
		}

		//요청에 대한 응답처리하기
		//client 에 대한 처리결과를 가지고 객체 : response
		//1. contentType : 응답파일에 대한 정보를 브라우저에 알려주는 것
		//   mimetype응 작성(text/html)
		//2. 페이지를 구성!(서블릿에서만) String으로 html문서를 제작!
		//3. 작성한 페이지를 client한테 전송할 Stream연결 response객체를 통해
		//4.작성 페이지를 전송(write, print, append)
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		//클라이언트의 스트림을 가져옴
		PrintWriter out = response.getWriter();
		//스트림을 통해 소스코드를 전송
		out.write("<html>");
		out.write("<body>");
		out.write("<h1>당신의 이름은" + name + " 이네요.</h1>");
		out.write("<h2>당신의 연세는 " + age + "살 입니다.</h2>");
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
		doGet(request, response);
	}

}
