package com.yj.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yj.login.dto.UserAuthDTO;
import com.yj.login.entity.UserAuth;
import com.yj.login.mapper.UserAuthMapper;
import com.yj.login.service.UserAuthService;
import com.yj.login.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl implements UserAuthService {
    @Autowired
    UserAuthMapper userAuthMapper;

    @Override
    public Result<UserAuthDTO> login(UserAuth user) {
        QueryWrapper<UserAuth> wrapper = new QueryWrapper<>();
        wrapper.eq("username",user.getUsername());
        UserAuth loginUser = userAuthMapper.selectOne(wrapper);
        if (loginUser !=null){
            if (loginUser.getPassword()==user.getPassword()){
                return Result.ok();
            }else {
                return Result.loginValid();
            }
        }
        return Result.UserValid();
    }

    @Override
    public Result<UserAuthDTO> register(UserAuth user) {
        UserAuth userAuth = new UserAuth();
        userAuth.setUsername(user.getUsername());
        userAuth.setPassword(user.getPassword());
        userAuthMapper.insert(userAuth);
        return Result.ok();
    }
}
