package cn.ahnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    //    去首页的几种方式
    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    //    去登录链接
    @GetMapping("/toLogin")
    public String toLogin() {
        return "views/login";
    }

    //    去level的方式
    @RequestMapping("/level1/{id}")
    public String toLevel1(@PathVariable("id") int id) {
        return "views/level1/" + id;
    }

    //    去leve2的方式
    @RequestMapping("/level2/{id}")
    public String toLevel2(@PathVariable("id") int id) {
        return "views/level2/" + id;
    }

    //    去leve3的方式
    @RequestMapping("/level3/{id}")
    public String toLevel3(@PathVariable("id") int id) {
        return "views/level3/" + id;
    }

}
