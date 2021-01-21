package test.example.mapper;

//指定为Spring环境中的单元测试

import org.example.Application;
import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//指定为Spring环境中的单元测试
@RunWith(SpringRunner.class)
//指定为SpringBoot环境的单元测试，Application为启动类
@SpringBootTest(classes = Application.class)
//使用事务，在SpringBoot的单元测试中会自动回滚
@Transactional
public class UserMapperTest {
    @Autowired
    private UserMapper mapper;

    @Test
    public void testSelectUser() {
        User user = mapper.selectUser(1);
        System.out.println("查询结果："+user);
    }

    @Test
    public void testSelectUsers() {
        List<User> users = mapper.selectUsers("%a%", 1, 4);
        for (User user:users) {
            System.out.println("查询结果："+user);
        }
    }

}
