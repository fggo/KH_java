package com.kh.spring.board.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.board.model.service.BoardService;

@Controller
public class BoardController {
  private Logger logger = LoggerFactory.getLogger(BoardController.class);

  @Autowired
  private BoardService service;
  
  @RequestMapping("/board/boardList.do")
  public String boardList(@RequestParam(value="cPage", required=false, defaultValue="0") int cPage) {

    int numPerPage = 5;
    List<Map<String, String>> list = service.selectBoardList(cPage, numPerPage);
    int totalCount = service.selectBoardCount();

    return "board/board";
  }


}
