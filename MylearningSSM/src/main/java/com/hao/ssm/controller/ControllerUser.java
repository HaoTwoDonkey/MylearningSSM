package com.hao.ssm.controller;


import com.hao.ssm.common.MD5Util;
import com.hao.ssm.common.Result;
import com.hao.ssm.common.ResultGenerator;
import com.hao.ssm.pojo.User;
import com.hao.ssm.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author : hao
 * @description :
 * @time : 2018/3/9 14:53
 */
@RestController
public class ControllerUser {

    @Autowired
    private UserService userService;

    private static final Logger log = Logger.getLogger(ControllerUser.class);

    @RequestMapping("/login")
    public Result login(User user) {
        try {
            String Md5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
            user.setPassword(Md5pwd);
        } catch (Exception e) {
            user.setPassword("");
        }

        User result = userService.login(user);

        if (result == null) {
            log.debug("登录失败");
            return ResultGenerator.genFailResult("登录失败");
        }
        return ResultGenerator.genSuccessResult(result);
    }

}
