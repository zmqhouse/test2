package com.zmq.controller;

import com.zmq.pojo.User;
import com.zmq.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("login")
    public String login() {
        System.out.println("go to login page");
        return "login";

    }

    @PostMapping("savelogin")
    public String toLogin(User user) {
        System.out.println("login");
        //获取subject，调用login
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        token.setRememberMe(true);
        //登录失败会抛出异常
        subject.login(token);
        return "index";


    }

    @GetMapping("all")
    public String queryAllUser() {
        System.out.println("query all users");
        return "index";
    }

    @RequestMapping("perm/error")
    public String error(){
        System.out.println("权限不足");
        return "error";
    }
    @RequestMapping("register")
    public String register(){
        System.out.println("go to register page");
        return "register";
    }
    @PostMapping("saveRegister")
    public String saveRegister(User user){
        userService.insertAddUser(user);
        return "login";
    }
}
