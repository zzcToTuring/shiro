package com.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.shiro.test.mapper")
public class run {
    public static void main(String[] args) {
//        //创建一个默认的拦截器
//        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
//        //把创建好的拦截器，添加到系统中
//        SecurityUtils.setSecurityManager(defaultSecurityManager);
        SpringApplication.run(run.class, args);
    }
}
