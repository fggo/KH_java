package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class MemberCheckId
 */
@WebServlet("/checkIdDuplicate")
public class MemberCheckId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberCheckId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //사용자가 입력한 userid값이 db에 잇는지 확인하고, 있나 없나를 view에 출력!
	  //사용자가 보낸 데이터 받기
	  String userId = request.getParameter("userId");
	  
	  //데이터 중복 확인 비즈니스 로직 구현!
	  MemberService service = new MemberService();
	  boolean isUseable = service.selectCheckId(userId);
	  
	  //view결과 데이터 전송
	  request.setAttribute("userId", userId);
	  request.setAttribute("isUseable", isUseable);
	  request.getRequestDispatcher("/views/member/checkIdDuplicate.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
