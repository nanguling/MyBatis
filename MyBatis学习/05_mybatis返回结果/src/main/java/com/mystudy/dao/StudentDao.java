package com.mystudy.dao;

import com.mystudy.entity.MyStudent;
import com.mystudy.entity.Student;
import com.mystudy.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    public Student selectStudentById(Integer id);

    public List<Student> selectStudentParam(@Param("sid")Integer id,
                                        @Param("sage")Integer age);

    ViewStudent selectStudentReturn(Integer id);

    int countStudent();

    //定义方法返回Map
    Map<Object,Object> selectByIdReturnMap(Integer id);

    /**
     * 使用resultMap定义映射关系
     */
    List<Student> selectAllStudent();

    List<MyStudent> selectMyStudent();

    List<MyStudent> selectDiffColProperty();

    /**
     * 第一种模糊查询
     * 在java代码中，指定like的内容
     */
    List<Student> selectLikeOne(String name);

    /**
     * name就是 老 这个值，在mapper中拼接like %老%
     */
    List<Student> selectLikeTwo(String name);
}
