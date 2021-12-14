package cn.ahnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//开启异步功能的注解
@EnableAsync
//开启定时任务注解
@EnableScheduling
@SpringBootApplication
public class Springboot10TaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot10TaskApplication.class, args);
    }

}
