package com.kh.prac.model.service;

import java.util.List;
import java.util.Map;


public interface EmpService {
  int insertEmp(Map<String, Object> param);
  List<Map> searchEmp(Map<String, Object> param);
}
