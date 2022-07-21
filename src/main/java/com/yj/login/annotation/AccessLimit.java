package com.yj.login.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 接口限流自定义注解
 */
@Target(ElementType.METHOD)  //用在用法上的注解
@Retention(RetentionPolicy.RUNTIME) //运行时注解
public @interface AccessLimit {
    /**
     * 限制周期（秒）
     */
    int seconds();

    /**
     * 规定周期内限制次数
     */
    int maxCount();


    /**
     * 当自定义注解超出这个限制时则抛出该信息异常
     */
    String msg() default "什么你也知道我是小吃货她爸？" ;
}
