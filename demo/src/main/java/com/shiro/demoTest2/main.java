package com.shiro.demoTest2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

public class main {
    public static void main(String[] args) {

        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        IniRealm iniRealm = new IniRealm("classpath:shiro_2.ini");
        defaultSecurityManager.setRealm(iniRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "z3");
        subject.login(token);
        //判断用户是否拥有 "common"角色
        System.out.println(subject.hasRole("common"));
        //判断其是否具有"write"权限
        System.out.println(subject.isPermitted("user:write"));
        //使用此方法，同样可检测其权限 没有返回值，如果没有权限会抛出相关异常
        subject.checkPermission("user:exe");
    }
}
