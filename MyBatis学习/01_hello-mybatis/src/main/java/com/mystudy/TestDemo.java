package com.mystudy;

import com.mystudy.entity.Testr;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestDemo {
    public static void main(String[] args) throws IOException {
        //访问mybatis读取test表中数据
        //1.定义mybatis主配置文件的名称,从类路径的根开始(target/class)
        String config = "mybatis.xml";
        //2.读取这个config表示的文件
        InputStream is = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(is);
        //5.【重要】获取SqkSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //6.【重要】指定要执行的sql语句的标识。  sql映射文件中的namespace + "." + 标签的id值
        //String sqlId = "com.mystudy.dao.TestDao" + "." + "selectTest";
        String sqlId = "com.mystudy.dao.TestDao.selectTest";
        //7.【重要】执行sql语句，通过sqlId找到语句
        List<Testr> list =  sqlSession.selectList(sqlId);
        //8.输出结果
        /*for (Test t:list) {
            System.out.println(t);
        }*/
        list.forEach(testr -> System.out.println(testr));
        //9.关闭SqlSession对象
        sqlSession.close();
    }
}
