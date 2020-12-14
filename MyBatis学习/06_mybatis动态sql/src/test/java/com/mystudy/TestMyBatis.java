package com.mystudy;

import com.github.pagehelper.PageHelper;
import com.mystudy.dao.StudentDao;
import com.mystudy.entity.Student;
import com.mystudy.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMyBatis {
    @Test
    public void selectStudentIf() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        /*student.setName("海绵宝宝");
        student.setAge(18);*/
        //student.setName("海绵宝宝");
        student.setAge(20);
        List<Student> list = dao.selectStudentIf(student);
        list.forEach(student1 -> System.out.println("if学生=="+student1));
    }

    @Test
    public void selectStudentWhere() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        //student.setName("海绵宝宝");
        //student.setAge(18);
        //student.setName("海绵宝宝");
        //student.setAge(20);
        List<Student> list = dao.selectStudentWhere(student);
        list.forEach(student1 -> System.out.println("where学生=="+student));
    }

    @Test
    public void selectForeachOne() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(2);
        idList.add(3);
        List<Student> list = dao.selectForeachOne(idList);
        list.forEach(student -> System.out.println("foreachOne学生=="+student));
    }

    @Test
    public void selectForeachTwo() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> stuList = new ArrayList<>();
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        student1.setId(1);
        student2.setId(2);
        student3.setId(3);
        stuList.add(student1);
        stuList.add(student2);
        stuList.add(student3);
        List<Student> list = dao.selectForeachTwo(stuList);
        list.forEach(student -> System.out.println("foreachTwo学生=="+student));
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //加入PageHelper的方法，分页
        //pageNum:第几页，从1开始
        //pageSize：一页中有多少行数据
        PageHelper.startPage(3,2);
        List<Student> list = dao.selectAll();
        list.forEach(student -> System.out.println("where学生=="+student));
    }
}


