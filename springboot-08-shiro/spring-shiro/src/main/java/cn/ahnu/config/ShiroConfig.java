package cn.ahnu.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 *       Subject  用户
 *       SecurityManager 管理所有用户
 *       Realm 连接数据库
 *
 */
@Configuration
public class ShiroConfig {

//    ShiroFilterFactoryBean 3
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
//        添加shiro的内置过滤器
        /*
        * anon：无需认证即可访问
        * authc：必须认证才能访问
        * user：必须拥有才能访问
        * perms：拥有对某个资源的权限才能访问
        * role：拥有某个角色权限才能访问
        * */
        Map<String,String> filterMap = new LinkedHashMap<>();
//        授权
        filterMap.put("/user/toAdd","perms[user:add]");
        filterMap.put("/user/toUpdate","perms[user:update]");
//        设置要认证的内容，即user下的请求,支持通配符
        filterMap.put("/user/*","authc");

//
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

//        设置拦截之后进入的页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
//        未授权进入的页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noauth");

        return shiroFilterFactoryBean;
    }



//    DefaultWebSecurityManager 2,
//    @Qualifier绑定第一步的UserRealm
//    Bean 下指定名称，为第三步的@Qualifier准备
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        return manager;
    }


    //创建realm对象 ，1.新建UserRealm类
    @Bean(name="userRealm")
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
//        userRealm.setAuthorizationCachingEnabled(false);
//        userRealm.setCredentialsMatcher(matcher);
        return userRealm;
    }

//   shiro dialect：用来整合thymeleaf
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

}
