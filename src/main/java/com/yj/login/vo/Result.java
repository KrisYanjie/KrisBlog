package com.yj.login.vo;

import com.yj.login.dto.UserAuthDTO;
import com.yj.login.entity.UserAuth;
import com.yj.login.enums.StatusCodeEnum;
import lombok.Data;

import static com.yj.login.enums.StatusCodeEnum.*;
/**
 * 接口返回类
 *
 * @author: 古丶野
 * @version: 1.0
 * @create: 2022-07-05 15:07
 **/

@Data
public class Result <T>{
    /**
     * 返回状态
     */
    private Boolean flag;
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    public static <T> Result<T> ok() {
        return restResult(true, null, SUCCESS.getCode(), SUCCESS.getDesc());
    }

    public static <T> Result<T> ok(T data) {
        return restResult(true, data, SUCCESS.getCode(), SUCCESS.getDesc());
    }

    public static <T> Result<T> ok(T data, String message) {
        return restResult(true, data, SUCCESS.getCode(), message);
    }

    public static <T> Result<T> fail() {
        return restResult(false, null, FAIL.getCode(), FAIL.getDesc());
    }

    public static <T> Result<T> fail(StatusCodeEnum statusCodeEnum) {
        return restResult(false, null, statusCodeEnum.getCode(), statusCodeEnum.getDesc());
    }

    public static <T> Result<T> fail(String message) {
        return restResult(false, message);
    }

    public static <T> Result<T> fail(T data) {
        return restResult(false, data, FAIL.getCode(), FAIL.getDesc());
    }

    public static <T> Result<T> fail(T data, String message) {
        return restResult(false, data, FAIL.getCode(), message);
    }

    public static <T> Result<T> fail(Integer code, String message) {
        return restResult(false, null, code, message);
    }

    public static <T> Result<T> loginValid() {
        return restResult(false, null,PASSWORD_ERROR.getCode(),PASSWORD_ERROR.getDesc());
    }

    public static <T> Result<T> CapchaError() {
        return restResult(false, null,CAPTCHA_ERROR.getCode(),CAPTCHA_ERROR.getDesc());
    }

    public static <T> Result<T> UserValid() {
        return restResult(false, null, USERNAME_NOT_EXIST.getCode(), USERNAME_NOT_EXIST.getDesc());
    }

    private static <T> Result<T> restResult(Boolean flag, String message) {
        Result<T> apiResult = new Result<>();
        apiResult.setFlag(flag);
        apiResult.setCode(flag ? SUCCESS.getCode() : FAIL.getCode());
        apiResult.setMessage(message);
        return apiResult;
    }

    private static <T> Result<T> restResult(Boolean flag, T data, Integer code, String message) {
        Result<T> apiResult = new Result<>();
        apiResult.setFlag(flag);
        apiResult.setData(data);
        apiResult.setCode(code);
        apiResult.setMessage(message);
        return apiResult;
    }




}

