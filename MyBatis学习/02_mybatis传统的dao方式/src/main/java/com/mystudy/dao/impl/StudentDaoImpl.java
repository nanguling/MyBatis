package com.mystudy.dao.impl;

import com.mystudy.dao.StudentDao;
import com.mystudy.entity.Student;
import com.mystudy.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudent() {
        //1.获取SqlSession对象
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //2.指定sql的标识
        String sqlId = "com.mystudy.dao.StudentDao.selectStudent";
        //3.执行sql
        List<Student> list = sqlSession.selectList(sqlId);
        //4.关闭
        sqlSession.close();
        return list;
    }

    @Override
    public int insertStudent(Student student) {
        //1.获取SqlSession对象
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        //2.指定sql标识
        String sqlId = "com.mystudy.dao.StudentDao.insertStudent";
        //3.执行sql
        int res = sqlSession.insert(sqlId,student);
        //4.手动提交事务
        sqlSession.commit();
        //5.关闭资源
        sqlSession.close();
        return res;
    }
}
