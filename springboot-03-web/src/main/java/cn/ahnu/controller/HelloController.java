package cn.ahnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
//@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String Hello(Model model) {
        model.addAttribute("t1", "hello,ThymeleafProperties");
//      测试传输数组
        model.addAttribute("lists", Arrays.asList("jhr", "jjj"));
        return "Hello";
    }
}

