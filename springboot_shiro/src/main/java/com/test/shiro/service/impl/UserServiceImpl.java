package com.test.shiro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.shiro.domain.User;
import com.test.shiro.mapper.UserMapper;
import com.test.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfoByName(String name){
        QueryWrapper<User> wrapper =new QueryWrapper<>();
        wrapper.eq("name",name);
        return userMapper.selectOne(wrapper);
    }

}




