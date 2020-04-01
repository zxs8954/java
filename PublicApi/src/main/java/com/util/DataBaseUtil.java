package com.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DataBaseUtil {
    public static SqlSession getSqlSession() throws IOException {
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("DataBaseConfig.xml");
        //构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }
}