package com.mystudy;

import com.mystudy.dao.StudentDao;
import com.mystudy.entity.Student;
import com.mystudy.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {
    @Test
    public void testSelectStudent() {
        /**
         * 使用mybatis动态代理的机制，使用SqlSession.getMapper(dao接口)
         * getMapper能够获取dao接口对应的实现类的对象
         */
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        System.out.println("dao=="+dao.getClass().getName());//com.sun.proxy.$Proxy4
        //调用dao得方法执行数据库得操作
        List<Student> list = dao.selectStudent();
        list.forEach(stu -> System.out.println(stu));
    }

    @Test
    public void testInsertStudent() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(5);
        student.setName("痞老板");
        student.setAge(28);
        int res = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println("成功插入"+res+"条数据");
    }
}
