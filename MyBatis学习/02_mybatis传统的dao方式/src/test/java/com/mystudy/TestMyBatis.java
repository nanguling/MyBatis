package com.mystudy;

import com.mystudy.dao.StudentDao;
import com.mystudy.dao.impl.StudentDaoImpl;
import com.mystudy.entity.Student;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {
    @Test
    public void testSelectStudent() {
        //com.mystudy.dao.StudentDao
        StudentDao sd = new StudentDaoImpl();
        /**
         * List<Student> list = sd.selectStudent();调用
         * 1.dao对象，类型是StudentDao，全限定名称：com.mystudy.dao.StudentDao
         *   全限定名称和namespace是一样的。
         * 2.dao调用的方法名称，selectStudent
         *   这个方法名就是mapper文件中的id值
         *
         * 3.通过dao中方法的返回值也可以确定mybatis要调用的SqlSession方法
         *   如果返回值是list，调用的是SqlSession.selectList()方法
         *   如果返回值是int或是非list，看mapper文件中的标签是insert还是update，就会调用SqlSession相应对的方法
         *
         * 【mybatis的动态代理】：mybatis根据dao的方法调用，获取执行sql语句的信息。
         *  mybatis根据你的接口，创建出一个dao接口实现类，并创建这个类的对象。
         *  完成SqlSession调用方法，访问数据库
         */
        List<Student> list = sd.selectStudent();
        list.forEach(stu -> System.out.println(stu));
    }

    @Test
    public void testInsertStudent() {
        StudentDao sd = new StudentDaoImpl();
        Student student = new Student();
        student.setId(4);
        student.setName("蟹老板");
        student.setAge(32);

        int res = sd.insertStudent(student);
        System.out.println("成功添加"+res+"条数据");
    }
}
