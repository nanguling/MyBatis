package com.mystudy.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {

    private static SqlSessionFactory factory = null;
    static {
        //1.定义mybatis主配置文件的名称，从类路径的根开始
        String config = "mybatis.xml";
        InputStream is = null;
        try {
            //2.读取这个主配置文件
            is = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3.创建builder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建factory对象
        factory = builder.build(is);
    }

    //获取sqlSession方法
    public static SqlSession getSqlSession() {
        //获得sqlsession对象
        SqlSession sqlSession = null;
        if (factory != null) {
            sqlSession = factory.openSession();//非自动提交事务
        }
        return sqlSession;
    }
}
