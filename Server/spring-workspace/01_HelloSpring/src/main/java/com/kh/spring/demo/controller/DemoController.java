package com.kh.spring.demo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.demo.model.service.DevService;
import com.kh.spring.demo.model.vo.Dev;
import com.kh.spring.demo.model.vo.Member;

//bean 등록(import stereotype) + method와 mapping @RequestMapping("");
@Controller
public class DemoController{
  
  //의존성 주입으로 자동으로 연결 (= new DevServiceImpl())
  @Autowired
  private DevService devService;
  
  @RequestMapping("/demo/demo.do")
  public String demo(){
    System.out.println("/demo/demo.do 컨트롤러 호출");
    //Resolver에 return 되면서 prefix suffix 붙은 url의 jsp페이지를 보여줌!
    //return: dispatcher servlet 역할 forward(request,response)와 같은 기능
    return "demo/demo";
  }

  /* 컨트롤러 메소드가 받을 수 있는 파라미터 :
    HttpServletRequest, HttpServletResponse, HttpSession, java.util.Locale(위치값 확인)
    InputStream, Reader: 요청에 대한 입력 스트림
    OutputStream, Writer: 요청에 대한 출력 스트림
    @PathVariable 
    @RequestParam
    @RequestHeader
    @CookieValue
    @RequestBody : ajax전송시 JSON 객체를 받는 파라미터 타입!

    Map, Model, ModelMap: view에 보낼 데이터를 보관하는 전용 객체
    Command 객체: Vo parameter로 넘어오는 값을 자동으로 Vo에 대입!
   **/

  @RequestMapping("/demo/demo1.do")
  public String demo1(HttpServletRequest request, HttpServletResponse response){
    String devName = request.getParameter("devName");
    int devAge = Integer.parseInt(request.getParameter("devAge"));
    String devEmail = request.getParameter("devEmail");
    String devGender = request.getParameter("devGender");
    String[] devLangs = request.getParameterValues("devLang");

    System.out.println(devName + devAge + devEmail + devGender);

    for(String s : devLangs)
      System.out.println(s); //demoResult.jsp 안만들어서 404뜨면서 syso console에 찍힘

    Dev dev = new Dev(devName, devAge, devEmail, devGender, devLangs);
    request.setAttribute("dev", dev);

    return "demo/demoResult";
  }
  
  //@RequestParam(value="inputName명") //매개변수 지정->매개변수 위치
  //age 입력 안했을때 예외처리 : required / defaultValue
  //공유객체를 request 사용하지 않고 Model객체를 이용하여 공유할 수 있음
//  @RequestMapping("/demo/demo2.do")
//  public String demo2(@RequestParam(value="devName") String devName, 
//                      @RequestParam(value="devAge", required = false, defaultValue="19") int devAge, 
//                      @RequestParam(value="devEmail") String devEmail, 
//                      @RequestParam(value="devGender") String devGender, 
//                      @RequestParam(value="devLang") String[] devLang,
//                      HttpServletRequest request) {
  //Model객체를 이용해서 데이터 넘기기
  @RequestMapping("/demo/demo2.do")
  public String demo2(String devName, int devAge, String devEmail,
                      String devGender, String[] devLang, Model model) {
////    must match parameter keyvalue name e.g. devName
    //required 예외처리는 못함
    System.out.println(devName);
    System.out.println(devAge);
    System.out.println(devEmail);
    System.out.println(devGender);
    System.out.println(devLang);
    
    Dev dev = new Dev(devName, devAge, devEmail, devGender, devLang);
//    request.setAttribute("dev", dev);
    model.addAttribute("dev", dev);

    return "demo/demoResult";
  }

  @RequestMapping("/demo/demo3.do")
  public String demo3(@RequestParam Map map, Model model) {
    System.out.println(map);

    model.addAttribute("dev", map);

    return "demo/demoResult";
  }

  @RequestMapping("/demo/demo4.do")
  public String demo4(Dev dev, Model model) {
//    다만 dev 등 넘기는 명칭이 프론트/백엔드가 같아야함
//    Session으로 받아도 됨

    model.addAttribute("dev", dev);

    return "demo/demoResult";
  }

  @RequestMapping("/demo/insertDev.do")
  public String insertDev(Dev dev) {
    //resolver에 의해 prefix suffix 붙어서 404 ERROR! -> redirect 사용!
    int result = devService.insertDev(dev);
    System.out.println(result);

//    return "/WEB-INF/views/.jsp"; // 404 ERROR!
    return "redirect:/";
//    return "redirect:/demo/demo2";
  }

  @RequestMapping("/demo/selectDevList.do")
  public String selectDevList(Model model) {

    List<Dev> list = devService.selectDevList();

    model.addAttribute("devList", list);

    return "demo/devList";
  }
  
  @RequestMapping("/demo/updateDev.do")
  public String updateDev(Dev dev) {
    System.out.println(dev);
    return "demo/devUpdateView";
  }

  @RequestMapping("/demo/updateDevEnd.do")
  public String updateDevEnd(Dev dev) {
    int result = devService.updateDev(dev);
    System.out.println("update result : " + result);
    return "redirect:/";
  }
  
  @RequestMapping("/demo/deleteDev.do")
  public String deleteDevEnd(Dev dev) {
    System.out.println(dev);
    int result = devService.deleteDev(dev);
    

    return "redirect:/demo/selectDevList.do";
  }
}
