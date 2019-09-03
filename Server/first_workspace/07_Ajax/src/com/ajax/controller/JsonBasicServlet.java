package com.ajax.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ajax.model.vo.User;
import com.google.gson.Gson;

/**
 * Servlet implementation class JsonBasicServlet
 */
@WebServlet("/jsonData")
public class JsonBasicServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JsonBasicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //server에서 javascript 객체로 프론트에 전송하기!
    //JSON 라이브러리가 있어야지 가능!
    //JSONObject객체를 이용
//    JSONObject jobj = new JSONObject();
//    jobj.put("name", "유병승");
//    jobj.put("age", 19);
//    jobj.put("weight", 65.5);
//    jobj.put("address", "경기도 시흥시");
//    jobj.put("hobby", "클래식,독서,여행");
//    jobj.put("breaktime", 50);

//    User u = new User(1, "user01", "유병승", "경기도 시흥시");
//    jobj.put("userNo", u.getUserNo());
//    jobj.put("userId", u.getUserId());
//    jobj.put("userName", u.getUserName());
//    jobj.put("userAddr", u.getUserAddr());
    
    //1. JSONObject 전송
//    response.setContentType("application/json;charset=utf-8"); //object 타입임을 client에 알림
//    response.getWriter().print(jobj);
    
    //2. JSON List 객체를 보내보자
    List<User> list = new ArrayList<User>();
    list.add(new User(1, "user01", "유병승", "경기도 시흥"));
    list.add(new User(2, "user02", "유병송", "경기동 시홍"));
    list.add(new User(3, "user03", "유병숭", "경기둥 시훙"));
    list.add(new User(4, "user04", "유병슨", "경기둉 시흉"));
    
    //JSONArray 객체를 이용해서 list를 보냄
//    JSONArray jlist = new JSONArray();
//
//    for(User u : list){
//      JSONObject jo = new JSONObject();
//      jo.put("userNo", u.getUserNo());
//      jo.put("userId", u.getUserId());
//      jo.put("userName", u.getUserName());
//      jo.put("userAddr", u.getUserAddr());
//
//      jlist.add(jo);
//    }
//    response.setContentType("application/json;charset=utf-8");
//    response.getWriter().print(jlist);
    response.setContentType("application/json;charset=utf-8");
    new Gson().toJson(list, response.getWriter());
//    new Gson().toJson(new User(1, "user01", "유병승", "경기도 시흥"), response.getWriter());
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
