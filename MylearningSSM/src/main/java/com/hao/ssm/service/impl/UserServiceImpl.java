package com.hao.ssm.service.impl;

import com.hao.ssm.mapper.UserMapper;
import com.hao.ssm.pojo.User;
import com.hao.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : hao
 * @description :
 * @time : 2018/3/9 15:16
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
