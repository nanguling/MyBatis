package com.mystudy.dao;

import com.mystudy.entity.Student;
import com.mystudy.vo.Queryparam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    /**
     * 一个简单类型参数：
     * 简单类型：mybatis把java的基本数据类型和String类型都叫做简单类型。
     *
     * 在mapper文件中要获取简单类型的一个参数的值，使用#{任意字符}
     */
    public Student selectStudentById(Integer id);

    /**
     * 多个参数：命名参数，在形参定义的前面加入@Param("自定义参数名称")
     */
    public List<Student> selectStudentParam(@Param("sid")Integer id,
                                        @Param("sage")Integer age);

    /**
     * 多个参数：使用java对象作为接口中方法的参数
     */
    List<Student> selectStudentObject(Queryparam param);

    List<Student> selectStudent(Student student);

    /**
     * 多个参数-简单类型：按位置传值
     * mybatis3.4之前使用#{0}。#{1}；之后使用#{arg0}，#arg{1}
     */
    List<Student> selectStudentPosition(String name,Integer age);

    /**
     * 多个参数，使用map存放多个值
     */
    List<Student> selectStudentMap(Map map);

    /**
     * 使用${}
     */
    List<Student> selectStudentUse$(String myname);

    List<Student> selectStudentUse$Order(String colName);
}
