package cn.ahnu.controller;

import cn.ahnu.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {
    @Autowired
    AsyncService asyncService;
    @RequestMapping("/hello")
    public String hello(){
        asyncService.hello();  //休眠三秒的功能，如果未使用异步功能，则会刷新后才显示
        return "hello Async";
    }
}
