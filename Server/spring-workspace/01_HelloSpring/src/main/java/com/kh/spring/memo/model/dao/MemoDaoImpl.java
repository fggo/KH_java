package com.kh.spring.memo.model.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

//spring bean으로 등록하고 알아서 관리: Dao는 Repository로 적어야 클래스가 bean으로 등록됨
@Repository
public class MemoDaoImpl implements MemoDao {

  @Override
  public List<Map<String, String>> selectList(SqlSessionTemplate sqlSession) {
    return sqlSession.selectList("memo.selectList");
  }
  
}
