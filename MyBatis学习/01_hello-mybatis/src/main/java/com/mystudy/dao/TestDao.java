package com.mystudy.dao;

import com.mystudy.entity.Testr;

import java.util.List;

//接口，操作test表
public interface TestDao {
    //查询test表的所有数据
    public List<Testr> selectTest();

    //插入方法
    //参数：test，表示要插入到数据库的数据
    //返回值：int，执行insert操作后，影响数据库的行数
    public int insetTest(Testr testr);
}
