package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
  //1. mybatis-config.xml 파일을 불러온다.
  public static SqlSession getSession() {
    String resource = "/mybatis-config.xml";
    SqlSession session = null;

    try {
      InputStream is = Resources.getResourceAsStream(resource); //Resources: mybatis

      //false: (auto commit false)
      //session commit rollback

//      SqlSessionFactoryBuilder fbuilder = new SqlSessionFactoryBuilder();
//      SqlSessionFactory factory = fbuilder.build(is);
//      session = factory.openSession(false);//트랜젝션을 자동으로 하지 않음

      session = new SqlSessionFactoryBuilder().build(is).openSession(false);

    } catch(IOException e) {
      e.printStackTrace();
    }

    return session;
  }
}
