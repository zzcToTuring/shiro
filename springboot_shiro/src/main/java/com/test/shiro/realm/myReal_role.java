package com.test.shiro.realm;


import com.test.shiro.domain.User;
import com.test.shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class myReal_role extends AuthorizingRealm {
    @Autowired
    private UserService userService;


    //自定义授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("进入自定义授权方法");
        //获取用户登录信息
        String name=principalCollection.getPrimaryPrincipal().toString();
        User user = userService.getUserInfoByName(name);
        List<String> user_role= Arrays.asList(user.getRole().split(","));
        List<String> user_p= Arrays.asList(user.getPermission().split(","));
        //1 创建对象存储其权限与角色信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //2 存储角色
        info.addRoles(user_role);
        info.addStringPermissions(user_p);
        return info;
    }

    //自定义登录认真方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken Token) throws AuthenticationException {
        //调用用户信息
        String name=Token.getPrincipal().toString();
        //获取数据库中存储的信息
        User user = userService.getUserInfoByName(name);


        //判断，并对其进行封装
        if (user!=null){
            AuthenticationInfo info = new SimpleAuthenticationInfo(
                    Token.getPrincipal(),
                    user.getPwd(),
                    Token.getCredentials().toString()
            );
            return info;
        }
        return null;
    }
}
