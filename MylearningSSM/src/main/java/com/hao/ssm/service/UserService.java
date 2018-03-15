package com.hao.ssm.service;


import com.hao.ssm.pojo.User;

/**
 * @author : hao
 * @description :
 * @time : 2018/3/9 15:16
 */
public interface UserService {
    User login(User user);

    User selectByPrimaryKey(Integer id);
}
