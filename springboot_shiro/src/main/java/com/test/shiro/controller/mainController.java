package com.test.shiro.controller;

import com.test.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class mainController {

    @RequestMapping("/login/userLogin")
    public String test(String name,String pwd, @RequestParam(defaultValue = "false")boolean rememberMe, HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        //创建token对象-通过账号密码创建token是一种最普通的方式
        UsernamePasswordToken token = new UsernamePasswordToken(name, pwd,rememberMe);
        System.out.println("re:  "+rememberMe);
        try {
            subject.login(token);
            System.out.println("登录成功");
            session.setAttribute("user",token.getPrincipal().toString());
            return "main.html";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("登录失败");
            return "login.html";
        }

    }

    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/see")
    public String see(){
        return "main";
    }


    //登录认证验证 rememberMe
    @GetMapping("/login/Rm")
    public String userLogin(HttpSession session) {
        session.setAttribute("user","rememberMe");
        return "main";
    }
}
