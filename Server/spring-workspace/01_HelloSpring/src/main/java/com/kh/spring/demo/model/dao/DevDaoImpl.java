package com.kh.spring.demo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.demo.model.vo.Dev;

//spring bean으로 등록하고 알아서 관리: Dao는 Repository로 적어야 클래스가 bean으로 등록됨
@Repository
public class DevDaoImpl implements DevDao {

  @Override
  public int insertDev(SqlSessionTemplate sqlSession, Dev dev) {
    return sqlSession.insert("dev.insertDev", dev);
  }

  @Override
  public List<Dev> selectDevList(SqlSessionTemplate sqlSession) {
    return sqlSession.selectList("dev.selectDevList");
  }

  @Override
  public int updateDev(SqlSessionTemplate sqlSession, Dev dev) {
    return sqlSession.update("dev.updateDev", dev);
  }

  @Override
  public int deleteDev(SqlSessionTemplate sqlSession, Dev dev) {
    return sqlSession.delete("dev.deleteDev", dev);
  }
  
}
