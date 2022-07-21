package com.yj.login.controller;

import com.yj.login.constant.CaptchaConstants;
import com.yj.login.dto.UserAuthDTO;
import com.yj.login.entity.UserAuth;
import com.yj.login.service.RedisService;
import com.yj.login.service.UserAuthService;
import com.yj.login.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class UserController {
    @Autowired
    private UserAuthService userAuthService;
    @Autowired
    private RedisService redisService;
    @PostMapping("login")
    public Result<UserAuthDTO> userLogin(@RequestBody UserAuth user){
        //打印日志的实现
        log.info("用户登陆的信息为[{}]",user.toString());

        return userAuthService.login(user);

    }



    @GetMapping("register")
    public Result<UserAuthDTO> register(@RequestBody UserAuth user,String code){



        //获取图片中争取的验证码
        String key= (String) redisService.get(CaptchaConstants.CAPTCHA_KEY_PREFIX);
        if (key==code){
            return userAuthService.register(user);
        }

            return  Result.CapchaError();

    }

}
