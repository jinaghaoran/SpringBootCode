package cn.ahnu.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        登录拦截器，获取session，判断是否登录
        Object loginuser = request.getSession().getAttribute("loginUser");
        if (loginuser == null) {
//            未登录则回到登录页面
            request.setAttribute("msg", "没有权限，请先登录");
            request.getRequestDispatcher("index.html").forward(request, response);
            return false;
        } else {
            return true;
        }

    }
}
