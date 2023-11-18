package com.test.shiro.controller;

import com.test.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class mainController {

    @Autowired
    private UserService userService ;

    @RequestMapping("/login/userLogin")
    public String test(String name,String pwd, HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        //创建token对象-通过账号密码创建token是一种最普通的方式
        UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);
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
        return "login.html";
    }
    @RequestMapping("/see")
    public String see(){
        return "main";
    }
}
