package com.ajax.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class AjaxUploadServlet
 */
@WebServlet("/ajaxUpload")
public class AjaxUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  if(!ServletFileUpload.isMultipartContent(request)) {
	    response.sendRedirect("/");
	    return;
	  }
	  //저장경로
	  String saveDir = getServletContext().getRealPath("/upload/ajax");
	  //파일 최대 크기
	  int maxSize = 1024*1024*1024; //1GB
	  MultipartRequest mr = new MultipartRequest(request,
	      saveDir, maxSize, "UTF-8", new DefaultFileRenamePolicy());
	  

	  //여러개 파일 업로드시 여러개 파일 받아오기
	  Enumeration<String> e = mr.getFileNames();
	  List<String> fileNames = new ArrayList<String>();
	  while(e.hasMoreElements()) {
	    fileNames.add(mr.getFilesystemName(e.nextElement()));
	  }
	  System.out.println(fileNames);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
