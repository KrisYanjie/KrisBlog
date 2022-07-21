package com.yj.login.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *  接口状态码枚举
 * @Author kris
 * @Date 2022/7/5 14:55
 * @Version 1.0
 */
@Getter
@AllArgsConstructor
public enum StatusCodeEnum {
    /**
     * 成功
     */
    SUCCESS(20000, "操作成功"),
    /**
     * 没有操作权限
     */
    AUTHORIZED(40300, "没有操作权限"),
    /**
     * 系统异常
     */
    SYSTEM_ERROR(50000, "系统异常"),
    /**
     * 失败
     */
    FAIL(51000, "操作失败"),
    /**
     * 参数校验失败
     */
    VALID_ERROR(52000, "参数格式不正确"),
    /**
     * 用户名已存在
     */
    USERNAME_EXIST(52001, "用户名已存在"),
    /**
     * 用户名不存在
     */
    USERNAME_NOT_EXIST(52002, "用户名不存在"),
    /**
     * qq登录错误
     */
    QQ_LOGIN_ERROR(53001, "qq登录错误"),
    /**
     * 微博登录错误
     */
    WEIBO_LOGIN_ERROR(53002, "微博登录错误"),
    /**
     * 验证码输入错误
     */
    CAPTCHA_ERROR(53003,"验证码输入错误"),
    /**
     * 密码输入错误
     */
    PASSWORD_ERROR(53004,"密码输入错误");
    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 描述
     */
    private final String desc;

}
