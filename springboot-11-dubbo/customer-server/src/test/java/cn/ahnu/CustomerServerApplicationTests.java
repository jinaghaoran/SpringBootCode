package cn.ahnu;

import cn.ahnu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerServerApplicationTests {

    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        userService.buyTicket();
    }

}
