package cn.ahnu.controller;

import cn.ahnu.mapper.UserMapper;
import cn.ahnu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import javax.websocket.server.PathParam;

@Controller
public class LoginController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/user/login")
    public String Login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session) {
        System.out.println("username"+username+"password"+password);
        if (!StringUtils.isEmpty(username)&&userMapper.getUserByName(username)!=null) {
            User user = userMapper.getUserByName(username);
            System.out.println(user+":user");
            if (user.getPassword().equals(password)) {
                session.setAttribute("loginUser", username);
                return "redirect:/main.html";
            }else {
                model.addAttribute("msg","用户不存在！");
                return "index";
            }

        } else {
            model.addAttribute("msg", "用户名或者密码错误");
            return "index";
        }
    }
}