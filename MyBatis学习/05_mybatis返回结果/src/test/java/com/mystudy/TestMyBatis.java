package com.mystudy;

import com.mystudy.dao.StudentDao;
import com.mystudy.entity.MyStudent;
import com.mystudy.entity.Student;
import com.mystudy.util.MyBatisUtil;
import com.mystudy.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
        List<Student> list = dao.selectStudentParam(1, 30);
        list.forEach(student -> System.out.println(student));
    }

    @Test
    public void tsetSelectStudentReturn() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        ViewStudent student = dao.selectStudentReturn(4);
        System.out.println(student);
    }

    @Test
    public void tsetCountStudent() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int res = dao.countStudent();
        System.out.println("一共有"+res+"条数据");
    }

    @Test
    public void tsetSelectByIdReturnMap() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<Object,Object> map = dao.selectByIdReturnMap(1);
        System.out.println("map=="+map);
    }

    @Test
    public void tsetSelectAllStudent() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> list = dao.selectAllStudent();
        list.forEach(student -> System.out.println(student));
    }

    @Test
    public void tsetSelectMyStudent() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> list = dao.selectMyStudent();
        list.forEach(student -> System.out.println(student));
    }

    @Test
    public void tsetSelectDiffColProperty() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> list = dao.selectDiffColProperty();
        list.forEach(student -> System.out.println(student));
    }

    @Test
    public void tsetSelectLikeOne() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //准备好like的内容
        List<Student> list = dao.selectLikeOne("%老%");
        list.forEach(student -> System.out.println(student));
    }

    @Test
    public void tsetSelectLikeTwo() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //准备好like的内容
        List<Student> list = dao.selectLikeTwo("老");
        list.forEach(student -> System.out.println("学生=="+student));
    }
}


