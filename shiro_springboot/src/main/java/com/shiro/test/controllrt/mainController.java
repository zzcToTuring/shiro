package com.shiro.test.controllrt;

import com.shiro.test.domain.User;
import com.shiro.test.mapper.UserMapper;
import com.shiro.test.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class mainController {
    @Autowired
    private UserService userService;
    @GetMapping("userLogin")
    @ResponseBody
    public String userLogin(String name,String pwd){
        System.out.println("开启登录流程");
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(name, pwd);
        try {
            subject.login(token);
            System.out.println("成功");
            return "登录成功";
        }catch (Exception e){
            System.out.println("失败");
            return "登录失败";

        }
    }
}
