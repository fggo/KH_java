package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.BoardComment;

/**
 * Servlet implementation class BoardCommentWriteServlet
 */
@WebServlet("/boardcomment/commentInsert")
public class BoardCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int boardRef = Integer.parseInt(request.getParameter("boardRef"));
	  String writer = request.getParameter("boardCommentWriter");
	  int level = Integer.parseInt(request.getParameter("boardCommentLevel"));
	  String content = request.getParameter("boardCommentContent");
	  int commentRef = Integer.parseInt(request.getParameter("boardCommentRef"));
	  
	  BoardComment bc = new BoardComment(level, writer, content, boardRef, commentRef);
	  int result = new BoardService().insertComment(bc);

	  String msg = result >0? "댓글등록 성공" : "댓글등록 실패";
	  String loc = "/board/boardView?no=" + boardRef;

	  String view = "/views/common/msg.jsp";
	  
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
