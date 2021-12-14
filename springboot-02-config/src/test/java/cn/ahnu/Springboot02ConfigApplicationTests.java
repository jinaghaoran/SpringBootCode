package cn.ahnu;

import cn.ahnu.pojo.Dog;
import cn.ahnu.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private Dog dog;
    @Autowired
    private Person person;

    @Test
    void pojo() {
        System.out.println(person);
    }

}
