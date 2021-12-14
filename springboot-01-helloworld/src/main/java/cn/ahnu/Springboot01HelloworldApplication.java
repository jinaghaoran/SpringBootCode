package cn.ahnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication标注是一个SpringBoot应用
@SpringBootApplication
public class Springboot01HelloworldApplication {

    public static void main(String[] args) {
//        将SpringBoot启动
        SpringApplication.run(Springboot01HelloworldApplication.class, args);
    }

}
