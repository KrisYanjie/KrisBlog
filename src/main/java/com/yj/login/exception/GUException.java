package com.yj.login.exception;

import com.yj.login.enums.StatusCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.yj.login.enums.StatusCodeEnum.FAIL;

/**
 * 业务异常
 *
 * @author: kris
 * @version: 1.0
 * @create: 2022-07-05 15:23
 **/
@Getter
@AllArgsConstructor
public class GUException extends RuntimeException{
    /**
     * 错误码
     */
    private Integer code = FAIL.getCode();

    /**
     * 错误信息
     */
    private final String message;

    public GUException(String message) {
        this.message = message;
    }

    public GUException(StatusCodeEnum statusCodeEnum) {
        this.code = statusCodeEnum.getCode();
        this.message = statusCodeEnum.getDesc();
    }
}

