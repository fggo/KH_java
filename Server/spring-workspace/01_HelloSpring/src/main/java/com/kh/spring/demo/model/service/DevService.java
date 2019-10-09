package com.kh.spring.demo.model.service;

import java.util.List;

import com.kh.spring.demo.model.vo.Dev;
import com.kh.spring.demo.model.vo.Member;

public interface DevService {
  int insertDev(Dev dev);
  List<Dev> selectDevList();
  int updateDev(Dev dev);
  int deleteDev(Dev dev);
}