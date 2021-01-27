package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    User selectUser(Integer id);

    //根据用户名模糊查询，like“%悟%”，id，查询给定范围的，2<=id<=4
    List<User> selectUsers(@Param("username") String username,@Param("sid") Integer sid,@Param("eid")Integer eid);

    //更新用户信息
    int insertUser(User user);

    List<User> selectAll();

    int batchInsert(List<User> users);

    int batchDelete(List<Integer> ids);
}
