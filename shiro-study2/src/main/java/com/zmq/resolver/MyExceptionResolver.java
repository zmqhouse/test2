package com.zmq.resolver;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        System.out.println(e.getClass());
        e.printStackTrace();//开发时必需
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof IncorrectCredentialsException || e instanceof UnknownAccountException) {
            modelAndView.setViewName("redirect:/user/login");
        }
        return modelAndView;
    }
}
