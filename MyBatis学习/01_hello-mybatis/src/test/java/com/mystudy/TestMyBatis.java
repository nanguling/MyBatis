package com.mystudy;

import com.mystudy.entity.Testr;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMyBatis {
    //测试方法，测试功能
    @Test
    public void testInsert() throws IOException {
        //测试mybatis向test表中添加数据
        //1.定义mybatis主配置文件的名称，从类路径的根开始
        String config = "mybatis.xml";
        //2.读取这个config表示的文件
        InputStream is = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(is);
        //5.创建SqlSession对象
        //SqlSession sqlSession = factory.openSession();
        SqlSession sqlSession = factory.openSession(true);//自动提交事务
        //6.指定要执行的sql语句的标识
        String sqlId = "com.mystudy.dao.TestDao.insetTest";
        //7.执行sql语句，通过sqlId找到语句
        Testr testr = new Testr();
        testr.setId(8);
        testr.setName("下扯蛋");
        testr.setAge(21);
        int res = sqlSession.insert(sqlId, testr);

        //mybatis默认不是自动提交事务的，所以在insert，update，delete后要手动提交事务
        //sqlSession.commit();//提交事务

        //8.输出结果
        System.out.println("成功添加"+res+"条数据");
        //9.关闭资源
        sqlSession.close();
    }
}
