package cn.ahnu;

import cn.ahnu.service.UserService;
import cn.ahnu.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringShiroApplicationTests {

    @Autowired
    UserServiceImpl userService;
    @Test
    void contextLoads() {
        System.out.println(userService.QueryUserByName("jhr"));
    }

}
