package com.mystudy;

import com.mystudy.dao.StudentDao;
import com.mystudy.entity.Student;
import com.mystudy.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMyBatis {
    @Test
    public void selectStudentById() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(4);
        System.out.println(student);
    }

    @Test
    public void testSelectStudentParam() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = dao.selectStudentParam(1,30);
        list.forEach(student -> System.out.println(student));
    }

    @Test
    public void selectStudentObject () {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        /*Queryparam param = new Queryparam();
        param.setName("派大星");
        param.setAge(20);*/
        Student student = new Student();
        student.setName("海绵宝宝");
        student.setAge(30);
        List<Student> list = dao.selectStudent(student);
        list.forEach(stu -> System.out.println(stu));
    }

    @Test
    public void selectStudentPosition() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = dao.selectStudentPosition("派大星",30);
        list.forEach(student -> System.out.println(student));
    }

    @Test
    public void selectStudentMap() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map map = new HashMap<>();
        map.put("name","蟹老板");
        map.put("age",20);
        List<Student> list = dao.selectStudentMap(map);
        list.forEach(student -> System.out.println(student));
    }

    @Test
    public void selectStudentUse$() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = dao.selectStudentUse$("'海绵宝宝'");
        list.forEach(student -> System.out.println(student));
    }

    @Test
    public void selectStudentUse$Order() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = dao.selectStudentUse$Order("name");
        list.forEach(student -> System.out.println(student));
    }
}
