package com.test.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class mainController_role {

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
        Subject subject = SecurityUtils.getSubject();
        session.setAttribute("user","rememberMe："+subject.getPrincipal().toString());
        return "main";
    }

    //登录认证验证角色
    @RequiresRoles("admin")
    @GetMapping("/role1")
    @ResponseBody
    public String userLoginRoles1() {
        System.out.println("登录认证验证角色");
        return "验证角色成功";
    }
    //登录认证验证角色
    @RequiresPermissions("删")
    @GetMapping("/role2")
    @ResponseBody
    public String userLoginRoles2() {
        System.out.println("登录认证验证角色");
        return "验证权限：删除 成功！";
    }

}