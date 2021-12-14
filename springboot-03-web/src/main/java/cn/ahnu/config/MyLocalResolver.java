package cn.ahnu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("l");
        System.out.println(language);
        Locale locale = Locale.getDefault();   //没有则使用默认的
        if (!StringUtils.isEmpty(language)) {   //工具类判断字符是否为空
//            分隔字符，得到国家与地区
            String[] strings = language.split("_");
            System.out.println("Local===>>>>" + strings[0]);
            locale = new Locale(strings[0], strings[1]);

        }

        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
//    配置国际化
}
