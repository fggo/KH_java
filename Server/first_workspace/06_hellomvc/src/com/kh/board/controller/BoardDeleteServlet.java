package com.kh.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/board/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int boardNo = Integer.parseInt(request.getParameter("no"));

	  Board b = new BoardService().selectBoardOne(boardNo, false);
	  if(b==null) {
	    request.setAttribute("msg", "존재하지 않는 Board는 삭제할수 없습니다.");
	    request.setAttribute("loc", "/board/boardList?cPage=1");
	    request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	    return;
	  }

	  int result  = new BoardService().deleteBoard(boardNo);
	  
	  String msg = "";
	  String loc = "";
	  String view = "/views/common/msg.jsp";
	  
	  if(result > 0) {
	    //이미지 파일도 같이 삭제
	    String saveDir = getServletContext().getRealPath(File.separator + "upload" + File.separator + "board");
	    File remove = new File(saveDir + "/" + b.getBoardRenamedFilename());
	    remove.delete();

	    msg= "board 삭제에 성공했습니다.";
	    loc = "/board/boardList?cPage=1";
	  }
	  else {
	    msg= "board 삭제에 실패 했습니다.";
	    loc = "/board/boardView?no="+ boardNo;
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
