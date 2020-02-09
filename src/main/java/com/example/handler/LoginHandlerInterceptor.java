package com.example.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆检查，需要在配置里额外配置才能定制和拓展
 * 在请求处理之前进行调用（Controller方法调用之前）
 * 基于URL实现的拦截器
// * @param request
// * @param response
// * @param handler
 * @return
 * @throws Exception
 */
public class LoginHandlerInterceptor extends HandlerInterceptorAdapter {
    //目标方法执行之前，从session中获取loginuser
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        if (path.matches("/index") || path.matches("/") || path.matches("/index/login")) {
            //不需要的拦截直接过
            return true;
        } else {
            // 这写你拦截需要干的事儿，比如取缓存，SESSION，权限判断等
            Object user = request.getSession().getAttribute("loginUser");
            if (user == null) {
                //未登陆，返回登陆页面
                request.setAttribute("msg", "没有权限请先登陆");
//            获取到转发器，请求和响应由MyMVCconfig转发到index
                // 服务器内部转发，可以带回request

                response.sendRedirect(request.getContextPath() + "/login");  //重定向到登录界面            return false;
            } else {
                //已登陆，放行请求
                System.out.println("\n已登陆，放行请求");
                return true;
            }
return  false;
        }

    }}

