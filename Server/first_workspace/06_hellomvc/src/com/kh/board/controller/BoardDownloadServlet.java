package com.kh.board.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardDownloadServlet
 */
@WebServlet("/board/boardFileDown")
public class BoardDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String root = getServletContext().getRealPath("/");
	  String saveDir = root + File.separator + "upload" + File.separator + "board";
	  String fileName = request.getParameter("fileName");
	  
	  //스트림열기
	  //대상파일을 Hard -> RAM으로 불러온 것!
	  File downFile = new File(saveDir + "/" + request.getParameter("fileName"));
	  BufferedInputStream bis = new BufferedInputStream(new FileInputStream(downFile)); // Buffered: 성능향상
	  //파일을 보낼곳 Stream 열기
	  ServletOutputStream sos = response.getOutputStream();
	  BufferedOutputStream bos = new BufferedOutputStream(sos);
	  
	  //한글파일을 보낼때 깨지지 않게 인코딩 처리
	  String resFileName = "";
	  boolean isMSIE = request.getHeader("user-agent").indexOf("MSIE") != -1
	      || request.getHeader("user-agent").indexOf("Trident") != -1;
	  if(isMSIE) { //Internet Explorer 한글파일명 깨짐현상 처리: Encoding 처리
	    resFileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
	  }
	  else {
	    resFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
	  }
	  // response 헤더작성, contentType: html/ 등 파일형식 확인
	  response.setContentType("application/octet-stream"); //2진 데이터를 보내기 위함
	  response.setHeader("Content-Disposition", "attachment;filenmae=" + resFileName);

	  //file 전송
	  int read = 1;
	  while((read=bis.read())!= -1) {
	    bos.write(read);
	  }

	  bos.close();
	  bis.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
