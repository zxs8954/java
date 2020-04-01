package com.database;

import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Test.update();
    }

    public static void function() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        Person p = new Person();
        p.setName("张雪松");
        p.setAge(28);
        p.setAddress("华盛顿");
        Integer i = sqlSession.insert("insert", p);
        sqlSession.commit();
        System.out.println(i);
    }

    public static void update() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSqlSession();
        Person p = new Person();
        p.setName("1113");
        p.setId(15);
        Integer i = sqlSession.update("2", p);
        System.out.println(i);
    }
}