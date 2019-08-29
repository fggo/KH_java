package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/board/boardView")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int boardNo = Integer.parseInt(request.getParameter("no"));
	  
	  //Cookie를 통해서 제한
	  Cookie[] cookies = request.getCookies();
	  String boardCookieVal = ""; //| | 로 나눠어진 f12에서의 cookie 값
	  boolean hasRead = false; //이 게시글을 읽었는지 확인하는 flag
	  
	  if(cookies != null) {
	    out:
	      for(Cookie c : cookies) {
	        String name = c.getName();
	        String value=c.getValue();

	        if("boardCookie".equals(name)) {
	          boardCookieVal = value;
	          if(value.contains("|" + boardNo + "|")) {
	            hasRead =true;
	            break out;
	          }
	        }
	      }
	  }
	  
	  if(!hasRead) {
	    Cookie boardCookie = new Cookie("boardCookie",
	        boardCookieVal+ "|" + boardNo + "|"); //읽은 boardNo를 Cookie에 누적

	    boardCookie.setMaxAge(-1); // -1: 닫거나 로그아웃 및 세션끊기면 쿠기 지워짐
	    response.addCookie(boardCookie);
	  }

	  Board b = new BoardService().selectBoardOne(boardNo, hasRead);

	  request.setAttribute("board", b);
	  request.getRequestDispatcher("/views/board/boardView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
