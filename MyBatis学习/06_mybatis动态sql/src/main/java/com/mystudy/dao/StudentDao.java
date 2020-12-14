package com.mystudy.dao;

import com.mystudy.entity.Student;

import java.util.List;

public interface StudentDao {

    //动态sql，使用java对象作为参数
    List<Student> selectStudentIf(Student student);

    List<Student> selectStudentWhere(Student student);

    //foreach用法1
    List<Student> selectForeachOne(List<Integer> list);

    //foreach用法2
    List<Student> selectForeachTwo(List<Student> list);

    /**
     * 使用pagehelper分页数据
     */
    List<Student> selectAll();
}
