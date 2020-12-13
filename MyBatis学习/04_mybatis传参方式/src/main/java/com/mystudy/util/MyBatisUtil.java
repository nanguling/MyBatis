package com.mystudy.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {

    private static SqlSessionFactory factory = null;
    static {
        //1.定义主配置文件名称，从类路径的根开始
        String config = "mybatis.xml";
        //2.读取主配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3.创建builder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建factory对象
        factory = builder.build(is);
    }

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        if (factory != null) {
            sqlSession = factory.openSession();//自动不提交事务
        }
        return sqlSession;
    }
}
