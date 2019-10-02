package com.mybatisdy.model.service;

import java.util.List;
import java.util.Map;

public interface EmpService {
  List<Map> selectSearch1(Map<String, String> param);
  List<Map> selectSearch2(Map<String, Object> param);
  List<Map<String, String>> selectEmpList(int cPage, int numPerPage);
  int selectEmpCount();
}
