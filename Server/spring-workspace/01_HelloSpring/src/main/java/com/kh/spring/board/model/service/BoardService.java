package com.kh.spring.board.model.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
  public List<Map<String,String>> selectBoardList(int cPage, int numPerPage);
  public int selectBoardCount();

}