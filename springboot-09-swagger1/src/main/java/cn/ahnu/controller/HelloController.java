package cn.ahnu.controller;

import cn.ahnu.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @ApiOperation("返回User")
    @PostMapping("/user")
    public User user(){
        return new User();
    }

    @ApiOperation("Hello控制类")
    @GetMapping("/hello")
//    对可以传入参数的方法进行测试
    public String hello(String username){
        return "hello"+username;
    }

}
