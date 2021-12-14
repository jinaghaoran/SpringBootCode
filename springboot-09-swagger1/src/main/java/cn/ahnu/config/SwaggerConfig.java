package cn.ahnu.config;

import com.sun.deploy.ui.AppInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {
//    配置swagger基础信息
    @Bean
    public Docket docket(Environment environment){
//        选择dev的环境，即application-dev.properties下的配置
        Profiles profiles = Profiles.of("dev");
        boolean isActive = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
//                配置扫描的接口的方法：RequestHandlerSelectors
//                any():扫描全部
//                none():不扫描
//                basePackage：扫描包
//                withClassAnnotation:扫描类上的注解
//                  withMethodAnnotation：扫描指定方法上的注解
                .apis(RequestHandlerSelectors.basePackage("cn.ahnu.controller"))
//                paths：过滤相关请求
//                .paths(PathSelectors.ant("/cn/ahnu/**"))
                .build()
                .enable(isActive)
//                设置分组
                .groupName("jhr");

    }
//    根据分组，设置多个角色
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("aa");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("bb");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("cc");
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact(
                "jhr",
                "http://www.jianghaoran.icu/",
                "505171123@qq.com");
//        源码中提到了，即Docket源码中ApiInfo的类，得到返回的相应结果
        return new ApiInfo(
                "jhr的Api Documentation",
                "这是一个简介",
                "1.0.0",
                "http://www.jianghaoran.icu/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());

    }
}
