package cn.ahnu.config;

import cn.ahnu.pojo.User;
import cn.ahnu.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;



public class UserRealm extends AuthorizingRealm {


//    授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权UserRealm->doGetAuthorizationInfo");
//        AuthorizationInfo info = new AuthorizationInfo();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        测试拦截使用，前面默认拦截了所有的用户，这里则授权给哪些用户，则需要在数据库中定义
        //info.addStringPermission("user:add");  //放行所有用户，即都可以访问add
        Subject subject = SecurityUtils.getSubject();  //获取角色
        //认证中第一个值为user，则这里取到了user，
        User user = (User) subject.getPrincipal();
        String perms = user.getPerms();
        System.out.println(perms);
//        通过拿到了user，则根据对象值拿到权限信息，通过信息得到访问权限
        info.addStringPermission(perms);

        return info;
    }

    @Autowired
    UserServiceImpl userService;


    //    认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行了认证UserRealm->doGetAuthenticationInfo");

//        用户名，密码，数据库中取得数据
//        String name="root";
//        String password="1234";

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
//        调用方法查询user，判断是否查询到user
        User user = userService.QueryUserByName(token.getUsername());
//        if (!token.getUsername().equals(name)){
//            return null;   //抛出异常，UnknownAccountException，即Controller中定义的用户名错误异常
//        }
//        查询到user的用户名，则验证,空则返回判断
        if (user==null){
            return null;
        }
//            String password = user.getPwd();
//        这里第一个值添加为user，则在授权时拿到user
        SimpleAuthenticationInfo simpleAuthenticationInfo= new SimpleAuthenticationInfo(user,
                user.getPwd(),""
        );
        System.out.println(simpleAuthenticationInfo);
        return simpleAuthenticationInfo;

    }
}
