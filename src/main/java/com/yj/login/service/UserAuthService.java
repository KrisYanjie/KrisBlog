package com.yj.login.service;

import com.yj.login.dto.UserAuthDTO;
import com.yj.login.entity.UserAuth;
import com.yj.login.vo.Result;

public interface UserAuthService {
    public Result<UserAuthDTO> login(UserAuth user);
    public Result<UserAuthDTO> register(UserAuth user);

}
