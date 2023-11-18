package com.test.shiro.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.test.shiro.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper extends BaseMapper<User> {

}




