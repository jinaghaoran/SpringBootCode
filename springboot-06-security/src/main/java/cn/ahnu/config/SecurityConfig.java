package cn.ahnu.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity   //开启Security模式
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        // 开启自动配置的登录功能
// /login 请求来到登录页
// /login?error 重定向到这里表示登录失败
//        定制login界面
        http.formLogin().loginPage("/toLogin")
                .usernameParameter("username").passwordParameter("password")
                .loginProcessingUrl("/login");


//        开启注销功能,设置注销后跳转的页面，这里是/ 即首页
        http.logout().logoutSuccessUrl("/index").logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"));

//        开启实现记住我功能,自定义名称
        http.rememberMe().rememberMeParameter("remember");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        在新的SpringBoot版本中，需要对密码进行加密处理，否则会500错误，登录不通过
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("jhr").password(new BCryptPasswordEncoder().encode("jhr123")).roles("vip1", "vip2", "vip3")
                .and()
                .withUser("demo").password(new BCryptPasswordEncoder().encode("1234")).roles("vip1")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("admin")).roles("vip1", "vip2");

    }
}
