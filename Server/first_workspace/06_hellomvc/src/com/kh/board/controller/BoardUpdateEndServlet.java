package com.kh.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import common.file.rename.MyFileRenamePolicy;

/**
 * Servlet implementation class BoardUpdateEndServlet
 */
@WebServlet("/board/boardUpdateEnd")
public class BoardUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  if(!ServletFileUpload.isMultipartContent(request)) {
	    request.setAttribute("msg", "enctype ERROR");
	    request.setAttribute("loc", "/");
	    request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	  }
	  
	  String saveDir = getServletContext().getRealPath(File.separator + "upload/board");
	  File dir = new File(saveDir);
	  if(!dir.exists()) {
	    dir.mkdirs(); //mkdirs 서브 dir 경로까지 전부
	  }
	  
	  int maxSize = 1024*1024*1024; // 1GB
	  
	  //MultipartRequest객체 생성
	  MultipartRequest mr = new MultipartRequest(
	      request,
	      saveDir,
	      maxSize,
	      "UTF-8",
	      new MyFileRenamePolicy()); //new DefaultRenamePolicy() 대신 커스텀 rename policy
	  int boardNo = Integer.parseInt(request.getParameter("no"));
	  
	  String newTitle = request.getParameter("title");
	  String newContent = request.getParameter("content");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
