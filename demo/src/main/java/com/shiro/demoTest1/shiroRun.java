package com.shiro.demoTest1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

import java.io.Serializable;

public class shiroRun {
    public static void main(String[] args) {
        //初始化获取 SecurityManager

        //该方法已过时，随时可能淘汰，了解即可
        /*IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro_1.ini");
        SecurityManager instance = factory.getInstance();
        SecurityUtils.setSecurityManager(instance);**/

        //创建一个默认的拦截器
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //创建Realm 以文本的形式进行读取
        IniRealm iniRealm = new IniRealm("classpath:shiro_1.ini");
        //把规则 添加到拦截器中
        defaultSecurityManager.setRealm(iniRealm);
        //把创建好的拦截器，添加到系统中
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        //获取subject对象
        Subject subject = SecurityUtils.getSubject();
        //创建token对象-通过账号密码创建token是一种最普通的方式
        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "z3");
        //开始登录过程
        try {
            //该对象进行登录，使用token
            subject.login(token);
            System.out.println("登录成功！");
        }catch (UnknownAccountException e){
            e.printStackTrace();
            System.out.println("用户不存在");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            System.out.println("密码错误");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("其他异常");
        }
    }
}
