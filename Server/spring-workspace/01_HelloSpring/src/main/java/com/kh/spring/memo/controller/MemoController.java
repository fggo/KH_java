package com.kh.spring.memo.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.memo.model.service.MemoService;

@Controller
public class MemoController {
  private Logger logger = LoggerFactory.getLogger(MemoController.class);
  @Autowired
  private MemoService service;
  
  @RequestMapping("/memo/memo.do")
  public String memo(Model model) {
    logger.debug("메모검색!");
    List<Map<String, String>> list = service.selectList();
    model.addAttribute("list", list);


    return "memo/memo";
  }


}
