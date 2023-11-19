package com.test.shiro.realm;


import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
public class ShiroConfig_cook {
    @Autowired
    private myReal myRealm;

    //配置 SecurityManager
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        //1 创建 defaultWebSecurityManager 对象
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();

        /*若加盐/使用相关加密方法，需要使用此代码额外配置
        //创建加密对象，并设置相关属性
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //采用 md5 加密，并设置迭代次数
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(3);
        //将加密对象存储到 myRealm 中
        myRealm.setCredentialsMatcher(matcher);
         */

        //将 myRealm 存入 defaultWebSecurityManager 对象
        defaultWebSecurityManager.setRealm(myRealm);

        //设置 rememberMe
        defaultWebSecurityManager.setRememberMeManager(rememberMeManager());

        //返回
        return defaultWebSecurityManager;
    }


    //配置 Shiro 内置过滤器拦截范围
    @Bean
    public DefaultShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        //设置不认证可以访问的资源
        definition.addPathDefinition("/login/userLogin","anon");
        definition.addPathDefinition("/login","anon");
        //配置登出过滤器
        definition.addPathDefinition("/logout","logout");
        //rememberMe 时能访问的界面
        definition.addPathDefinition("/**","user");
        //设置需要进行登录认证的拦截范围
        definition.addPathDefinition("/**","authc");

        return definition;
    }


    //cookie 属性设置
    public SimpleCookie rememberMeCookie(){
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        //设置跨域
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(30*24*60*60);
        return cookie;
    }
    //创建 Shiro 的 cookie 管理对象
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        cookieRememberMeManager.setCipherKey("1234567890987654".getBytes());
        return cookieRememberMeManager;
    }
}
