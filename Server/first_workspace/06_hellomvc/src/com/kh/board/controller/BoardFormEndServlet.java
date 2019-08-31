package com.kh.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.oreilly.servlet.MultipartRequest;

import common.file.rename.MyFileRenamePolicy;

/**
 * Servlet implementation class BoardWriteFormEnd
 */
@WebServlet("/board/boardFormEnd")
public class BoardFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFormEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  if(!ServletFileUpload.isMultipartContent(request)) {
	    //1.msg.jsp로 처리 2. define error page (web.xml)
	    request.setAttribute("msg", "게시판 에러!! enctype ERROR");
	    request.setAttribute("loc", "/");
	    request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	  }
	  
	  //1.실제파일 업로드 경로 가져오기   //저장할 경로 "/upload/board"
	  String saveDir = getServletContext().getRealPath(File.separator + "upload/board");
	  File dir = new File(saveDir);
	  if(!dir.exists()) {
	    dir.mkdirs(); //mkdirs 서브 dir 경로까지 전부
	  }
	  
	  //2. 업로드 파일크기 설정
	  int maxSize = 1024*1024*1024; // 1GB
	  
	  //MultipartRequest객체 생성
	  MultipartRequest mr = new MultipartRequest(
	      request,
	      saveDir,
	      maxSize,
	      "UTF-8",
	      new MyFileRenamePolicy()); //new DefaultRenamePolicy() 대신 커스텀 rename policy
	    
	  //클라이언트가 보내준 값을 DB에 저장
	  String title = mr.getParameter("title");
	  String writer = mr.getParameter("writer");
	  String content = mr.getParameter("content");
	  String oriFile = mr.getOriginalFileName("up_file");
	  String reFile = mr.getFilesystemName("up_file"); //myFileRenamePolciy()로 만들어진 파일명

	  Board b = new Board(title, writer, content, oriFile, reFile);
	  int result = new BoardService().insertBoard(b);
	  
	  String msg = "";
	  String loc = "";

	  if(result>0) {
	    msg = "게시글을 성공적으로 등록했습니다.";
	    loc = "/board/boardList";
	  } else {
	    //실패했으니 MultipartRequest로 생성된 파일을 지워줌
	    File remove = new File(saveDir + "/" + b.getBoardRenamedFilename());
	    remove.delete();

	    msg = "게시글 등록에 실패했습니다.";
	    loc = "/board/boardForm";
	  }
	  
	  request.setAttribute("msg", msg);
	  request.setAttribute("loc", loc);
	  request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
