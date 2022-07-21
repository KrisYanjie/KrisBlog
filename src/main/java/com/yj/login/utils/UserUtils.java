package com.yj.login.utils;

import com.yj.login.dto.UserDetailDTO;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author: kris
 * @version: 1.0
 * @create: 2022-07-05 15:21
 **/
@Component
public class UserUtils {
    /**
     * 获取当前登录用户
     *
     * @return 用户登录信息
     */
    public static UserDetailDTO getLoginUser() {
        //判断当前操作人员是否登录
        if (Objects.nonNull(SecurityContextHolder.getContext().getAuthentication()) && SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails) {
            return (UserDetailDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } else {
            return null;
        }
    }
}

