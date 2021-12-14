package cn.ahnu.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
//    首页
    @RequestMapping({"/","/index"})
    public String to(Model model){
        model.addAttribute("msg", "Hello,Shiro");
        return "index";
    }

// to add
    @RequestMapping("/user/toAdd")
    public String toAdd(){
        return "add";
    }

//    toUpdate
    @RequestMapping("/user/toUpdate")
    public String toUpdate(){
        return "update";
    }

//    toLogin
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

//    登录，进行验证
    @RequestMapping("/login")
    public String login(String username,String password,Model model){
//        获取用户数据
        Subject subject = SecurityUtils.getSubject();
//        封装数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
//        进行登录的验证
        try{
            subject.login(token);
            return "index";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }

//    未授权页面
    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthorized(){
        return "未经授权不能访问";
    }
}


