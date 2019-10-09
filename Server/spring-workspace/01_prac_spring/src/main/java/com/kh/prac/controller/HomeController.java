package com.kh.prac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
  
  @RequestMapping("/homeView")
  public String homeView() {
    System.out.println("homeview");
    return "mainChatView";
  }
}
