package cn.ahnu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //    配置Druid后台监控的servlet，设定它的url，账户密码，访问权限等
    @Bean
    public ServletRegistrationBean staticviewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        HashMap<String, String> initParameters = new HashMap<>();
//        后台监控的账户密码
        initParameters.put("loginUsername", "jhr");
        initParameters.put("loginPassword", "jhr");

//        后台访问权限，127.0.0.1，若为空，则允许所有
        initParameters.put("allow", "127.0.0.1");
        bean.setInitParameters(initParameters);
        return bean;

    }

    //    配置后台监控之filter过滤器
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        HashMap<String, String> initParameters = new HashMap<>();
        initParameters.put("exclusions", "*.js,*.css,/druid/*,/jdbc/*");
        bean.setInitParameters(initParameters);
        return bean;
    }
}
