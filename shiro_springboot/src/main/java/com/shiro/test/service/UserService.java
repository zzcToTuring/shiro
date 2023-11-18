package com.shiro.test.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.shiro.test.domain.User;

/**
* @author ASUS
* @description 针对表【user】的数据库操作Service
* @createDate 2023-11-17 21:30:54
*/
public interface UserService extends IService<User> {
    //用户登录
    User getUserInfoByName(String name);
}
