package com.test.shiro.realm;


import com.test.shiro.domain.User;
import com.test.shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class myReal extends AuthorizingRealm {
    @Autowired
    private UserService userService;


    //自定义授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
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
                    //用户输入-用户名
                    Token.getPrincipal(),
                    //真实-密码user.getPwd(),
                    user.getPwd(),
                    //如果加盐加密，其中需要添加加盐字段
                    //ByteSource.Util.bytes("salt"),
                    //用户输入-密码(已加密)
                    Token.getCredentials().toString()
            );
            return info;
        }
        return null;
    }
}
