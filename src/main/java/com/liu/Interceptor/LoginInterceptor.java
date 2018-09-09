package com.liu.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("in using!"+httpServletRequest.getRequestURI());

        if (httpServletRequest.getRequestURI().equals("/action/login")||httpServletRequest.getRequestURI().equals("/error")||httpServletRequest.getRequestURI().equals("/login")||httpServletRequest.getRequestURI().equals("/"))
                return true;
        else if (!httpServletRequest.getRequestURI().equals("/error")&&!httpServletRequest.getRequestURI().equals("/login")&&!httpServletRequest.getRequestURI().equals("/")&&httpServletRequest.getSession().getAttribute("userid")!=null&&!httpServletRequest.getSession().getAttribute("userid").toString().equals(""))
        {
            if (httpServletRequest.getRequestURI().equals("/stumanager")&&!httpServletRequest.getSession().getAttribute("userid").toString().equals("manager"))
            {
                httpServletResponse.sendRedirect("/");
                return  false;
            }
            else
                return true;
        }
        else
            httpServletResponse.sendRedirect("/");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
