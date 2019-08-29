package com.kh.notice.controller;

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
 * Servlet implementation class NoticeFileDownloadServlet
 */
@WebServlet("/notice/noticeFileDown")
public class NoticeFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*
	  1. 실제경로를 가져오기
	  2. 인코딩처리(한글에 대한), client가 보낼때도 처리
	  브라우저 url창에 한글/기호 입력되면 자동으로 인코딩
	  처리를 해주는 브라우저가 있고, 없는 브라우저가 있기에
	  개발자가 처리를 해줘야함. * 크롬은 안해줘도 됨!
	  3. 저장파일과 스트림연결(파일입출력)
	  4.response 헤더 수정
	    contentType=application/octet-stream, //binary 파일이 넘어감
	    Content-Disposition:attachment;filename=파일명 //attachment말고 inline은 안먹힘
	    attachment: download창이 뜸
	    inline: download창이 뜨지않고 다른 창에 뜸
	  5. 파일을 response한테 stream으로 전송하기!
	*/
	  //실제파일 경로 가져오기
	  String root = getServletContext().getRealPath("/");
	  String saveDir = root + File.separator + "upload" + File.separator + "notice";
	  String fileName = request.getParameter("fileName");
	  
	  //스트림열기
	  //대상파일을 Hard -> RAM으로 불러온 것!
	  File downFile = new File(saveDir + "/" + request.getParameter("fileName"));
	  BufferedInputStream bis = new BufferedInputStream(new FileInputStream(downFile)); // Buffered: 성능향상
	  //파일을 보낼곳 Stream 열기
	  ServletOutputStream sos = response.getOutputStream();
	  BufferedOutputStream bos = new BufferedOutputStream(sos);
	  
	  //한글파일을 보낼때 깨지지 않게 인코딩 처리
	  //f12-network user-agent에 MSIE/Trident있음
	  String resFileName = "";
	  boolean isMSIE = request.getHeader("user-agent").indexOf("MSIE") != -1
	      || request.getHeader("user-agent").indexOf("Trident") != -1;
	  if(isMSIE) { //Internet Explorer 한글파일명 깨짐현상 처리: Encoding 처리
	    //띄어쓰기를 URL방식으로 바꾸기
	    resFileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", "%20");
	  }
	  else {
	    resFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
	  }
	  // response 헤더작성
	  response.setContentType("application/octet-stream"); //2진 데이터를 보내기 위함
	  //contentType: html/ 등 파일형식 확인
	  response.setHeader("Content-Disposition", "attachment;filenmae=" + resFileName);
//	  response.setHeader("Content-Disposition", "inline;filenmae=" + resFileName); 
	  //크롬에서는 inline 안됨. Internet EXplorer 에서 다운로드 대신 이미지 url 열어줌
	  //크롬에서 파일 다운시 밑에 다운로드바 바로 다운 되거나, 다운로드 창 뜨게됨 
	  //IE에서는 'inline' 세팅으로 바꾸면, 사진 창url 으로 넘어감
	  //file 전송
	  int read = -1;
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
