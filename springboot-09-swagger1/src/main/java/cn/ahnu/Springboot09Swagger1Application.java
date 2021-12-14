package cn.ahnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@SpringBootApplication
public class Springboot09Swagger1Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09Swagger1Application.class, args);
    }

}
