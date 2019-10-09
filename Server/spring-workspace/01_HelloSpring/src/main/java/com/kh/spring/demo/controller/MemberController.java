package com.kh.spring.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.demo.model.service.MemberService;
import com.kh.spring.demo.model.vo.Member;

//bean 등록(import stereotype) + method와 mapping @RequestMapping("");
@Controller
public class MemberController{
  
  //의존성 주입으로 자동으로 연결 (= new DevServiceImpl())
  @Autowired
  private MemberService memberService;
  
  @RequestMapping("/member/memberLogin.do")
  public String login(Member m, HttpSession session) {
    Member loginMember = memberService.selectMemberOne(m);

    if(loginMember !=null) {
      session.setAttribute("loginMember", loginMember);
      System.out.println(loginMember);
    }

    return "redirect:/";
  }
}
