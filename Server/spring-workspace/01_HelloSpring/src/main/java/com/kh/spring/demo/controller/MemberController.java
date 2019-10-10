package com.kh.spring.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.spring.demo.model.service.MemberService;
import com.kh.spring.demo.model.vo.Member;

//bean 등록(import stereotype) + method와 mapping @RequestMapping("");
//sessionAttribute에 model에서 loginMember찾아서 session에 자동으로 올림
//여러개 value 등록 가능(session에 add)
@SessionAttributes(value= {"loginMember"})
@Controller
public class MemberController{
  
  private Logger logger = LoggerFactory.getLogger(MemberController.class);
  
  //의존성 주입으로 자동으로 연결 (= new MemberServiceImpl())
  @Autowired
  private MemberService memberService;

  @Autowired
  private BCryptPasswordEncoder pwEncoder;
 
//  @RequestMapping("/member/memberLogin.do")
//  public String login(Member m, HttpSession session) {
//    Member loginMember = memberService.selectMemberOne(m);
//
//    if(loginMember !=null) {
//      session.setAttribute("loginMember", loginMember);
//      System.out.println(loginMember);
//    }
//
//    return "redirect:/";
//  }

  /**
   * 
   * @param m
   * @param model
   * @param session SessionStatus
   * @return String(jsp)
   */
  @RequestMapping("/member/memberLogin.do")
//  public String login(Member m, Model model, HttpSession session) {
  public String login(Member m, Model model, SessionStatus session) {

    Member loginMember = memberService.selectMemberOne(m);
//    Model: request 대신에 씀

    String msg="";
    String loc = "/";

//    if(loginMember.getPassword().equals(m.getPassword())
    logger.debug(m.getUserId()); //debug 위단계들만 출력 xml에서 info로 세팅하면 debug등 안뜸
    logger.debug(m.getPassword());
    logger.debug(pwEncoder.encode(m.getPassword()));
    logger.debug(loginMember.getPassword());

    if(loginMember != null && pwEncoder.matches(m.getPassword(), loginMember.getPassword())) {
      msg ="login success";
      model.addAttribute("loginMember", loginMember); //model은 request같아서 세션 유지 X
      //@SessionAttributes등록하면 loginMember를 session에 올림
    }
    else
      msg = "login fail";
    
//    session.setAttribute("loginMember", loginMember);

    model.addAttribute("msg", msg);
    model.addAttribute("loc", loc);

    return "common/msg";
  }
  
  @RequestMapping("/member/memberEnroll.do")
  public String enroll() {
    //only changes view
    return "member/memberEnroll";
  }

  @RequestMapping("/member/memberEnrollEnd.do")
  public String enrollEnd(Member m, Model model) {
    m.setPassword(pwEncoder.encode(m.getPassword()));
    int result = memberService.insertMember(m);

    String msg ="";
    String loc= "/";
    System.out.println(m);

    if(result > 0) msg= "Member Enroll Succcess";
    else msg="Member Enroll Failed...";

    model.addAttribute("msg", msg);
    model.addAttribute("loc", loc);

    System.out.println(m);
    System.out.println(result);

    return "common/msg";
  }
  
  @RequestMapping("/member/memberLogout.do")
//  public String logout(Member m, Model model, HttpSession session) {
  public String logout(Member m, Model model, SessionStatus status) {
//    model.addAttribute("loginMember", m);
//    session.invalidate();

    if(!status.isComplete()) //check if session is closed
      status.setComplete(); //httpsessison.invalidate()와 같은기능

    return "redirect:/";
  }

//  @RequestMapping("/member/memberDelete.do")
//  public String delete(Member m, Model model) {
//    String msg = "";
//    String loc="/";
//    int result = memberService.deleteMember(m);
//    return "common/msg";
//  }
  
  
}
