package com.mybatisdy.model.service;

import java.util.List;
import java.util.Map;

public interface EmpService {
  List<Map> selectSearch1(Map<String, String> param);
}
