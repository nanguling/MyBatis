package com.mystudy;

import com.mystudy.entity.Testr;
import com.mystudy.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class TestDemo2 {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
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
