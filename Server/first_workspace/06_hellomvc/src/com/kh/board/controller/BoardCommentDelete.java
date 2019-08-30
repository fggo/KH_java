package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;

/**
 * Servlet implementation class BoardCommentDelete
 */
@WebServlet("/board/boardCommentDelete")
public class BoardCommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardCommentDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int boardRef = Integer.parseInt(request.getParameter("no"));
	  int commentNo = Integer.parseInt(request.getParameter("commentNo"));
	  
	  int result = new BoardService().deleteComment(boardRef, commentNo);
	  
	  String msg = result > 0 ? "답글 삭제 완료" : "답글 삭제 실패!";
	  String loc= "/board/boardView?no=" + boardRef;
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
