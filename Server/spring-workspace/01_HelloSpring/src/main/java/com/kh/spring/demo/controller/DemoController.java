package com.kh.spring.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//bean 등록(import stereotype) 
@Controller
public class DemoController{
  
  //+ method와 mapping
  @RequestMapping("/demo/demo.do")
  public String mytestfunc(){
      //method parameter?
    System.out.println("/demo/demo.do 컨트롤러 호출");
    return "demo/demo"; //Resolver에 return 되면서 prefix suffix 붙은 url의 jsp페이지를 보여줌!
    //return: dispatcher servlet 역할 forward(request,response)와 같은 기능
    

  }

//컨트롤러 메소드가 받을 수 있는 파라미터
//HttpServletRequest, HttpServletResponse, HttpSession, java.util.Locale
//InputStream, Reader: 요청에 대한 입력 스트림
//OutputStream, Writer: 요청에 대한 출력 스트림
// @PathVariable 
// @RequestParam
// @RequestHeader
// @CookieValue
// @RequestBody : ajax전송시 JSON 객체를 받는 파라미터 타입!

//Map, Model, ModelMap 보낼 데이터를 보관하는 전용 객체

//Command 객체 VO parameter로 넘어오는 값을 자동으로 VO에 대입!
  @RequestMapping("/demo/demo1.do")
  public String demo1(HttpServletRequest req, HttpServletResponse res){
    String  devName = req.getParameter("devName");
    int  devAge = Integer.parseInt(req.getParameter("devName"));
    String  devEmail = req.getParameter("devEmail");
    String  devGender = req.getParameter("devGender");
    String [] devLangs = req.getParameterValues("devLang");

    System.out.println(devName + devAge + devEmail + devGender);
    for(String s : devLangs) System.out.println(s);
    //404뜨면서 syso console에 찍힘

    return "demo/demoResult";
  }
}
