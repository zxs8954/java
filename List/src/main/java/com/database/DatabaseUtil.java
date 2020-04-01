package com.database;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


public class DatabaseUtil {
   public static SqlSession getSqlSession() throws IOException {
      String resource = "dataBase.xml";
      // 读取配置文件
      InputStream inputStream = Resources.getResourceAsStream(resource);
      // 构建sqlSessionFactory
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      // 获取sqlSession    true自动提交事务
      SqlSession sqlSession = sqlSessionFactory.openSession(true);
      //返回sqlSession
      return sqlSession;
   }
}
