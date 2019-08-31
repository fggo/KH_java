package com.kh.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
	  
	  String saveDir = getServletContext().getRealPath(File.separator + "upload" + File.separator + "board");
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


	  String boardNo = mr.getParameter("no");
	  String title = mr.getParameter("title");

	  String old_ori = mr.getParameter("old_up_file_ori");
	  String old_re = mr.getParameter("old_up_file_re");
	  String new_ori = mr.getOriginalFileName("new_up_file");
	  String new_re = mr.getFilesystemName("new_up_file");
	  String content = mr.getParameter("content");
	  
	  Map<String, String> newAttr = new HashMap<String, String>();
	  newAttr.put("boardNo", boardNo);
	  newAttr.put("title", title);
	  newAttr.put("ori", new_ori ==null? old_ori : new_ori);
	  newAttr.put("re", new_re == null? old_re : new_re);
	  newAttr.put("content", content);

	  Board boardOld = new BoardService().selectBoardOne(Integer.parseInt(boardNo), false);
	  int result = new BoardService().updateBoard(boardOld, newAttr);

	  String msg = "";
	  String loc = "";
	  String view = "/views/common/msg.jsp";

	  if(result>0) {
	    //update 성공하여 이전 파일 삭제 (update할 새로운 파일을 지정한 경우에만 삭제)
	    if(new_ori!=null && new_re != null) { 
        File remove = new File(saveDir + "/" + old_re);
        remove.delete();
	    }

	    msg = "게시글을 성공적으로 업데이트 했습니다.";
	    loc = "/board/boardView?no=" + boardNo;
	  } else {
	    //update 실패했으니 MultipartRequest로 생성된 파일을 지워줌
	    File remove = new File(saveDir + "/" + new_re);
	    remove.delete();

	    msg = "게시글 업데이트에 실패했습니다.";
	    loc = "/board/boardUpdate?no=" + boardNo;
	  }

	  request.setAttribute("msg", msg);
	  request.setAttribute("loc", loc);

	  request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
