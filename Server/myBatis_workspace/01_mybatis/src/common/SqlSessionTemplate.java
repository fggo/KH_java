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
		//resources 폴더는 같은 루트로 인식
		SqlSession session = null;

		try {
			InputStream is = Resources.getResourceAsStream(resource); //Resources: mybatis가 제공하는 객체

			//false: 트렌젝션을 자동으로 하지 않음(auto commit false와 비슷)
			//session이 commit rollback모두 수행

//			SqlSessionFactoryBuilder fbuilder = new SqlSessionFactoryBuilder();
//			SqlSessionFactory factory = fbuilder.build(is);
//			session = factory.openSession(false);

			session = new SqlSessionFactoryBuilder().build(is).openSession(false);

		} catch(IOException e) {
			e.printStackTrace();
		}

		return session;
	}
}
