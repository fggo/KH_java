package com.kh.board.controller;

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
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class BoardWriteFormEnd
 */
@WebServlet("/board/boardFormEnd")
public class BoardWriteFormEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteFormEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  if(!ServletFileUpload.isMultipartContent(request)) {
	    request.setAttribute("msg", "게시판 에러!! enctype ERROR");
	    request.setAttribute("loc", "/");
	    request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	    return;
	  }

	  String root = getServletContext().getRealPath("/");
	  String saveDir = root+"/upload/board";
    int maxSize = 1024 * 1024*10; //10MB

    MultipartRequest mr = new MultipartRequest(request,
                                               saveDir,
                                               maxSize,
                                               "UTF-8",
                                               new DefaultFileRenamePolicy());
    
    String boardTitle = mr.getParameter("title");
    String boardWriter = mr.getParameter("writer");
    String boardContent = mr.getParameter("content");
    String fileName = mr.getOriginalFileName("up_file");
    String reName = mr.getFilesystemName("up_file");
    //sequence로 어차피 notice_no 들어가므로 아무 값이나 넣음(=0)
    Board b = new Board(0, boardTitle, boardWriter, boardContent, fileName, reName, null, 0);

    int result = new BoardService().insertBoard(b);

    String msg = "";
    String loc = "";

    if(result > 0) {
      msg = "게시글 등록완료";
      loc="/board/boardView?no="+result;
    }
    else{
      msg = "공지사항 등록실패";
      loc="/board/boardForm";
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
