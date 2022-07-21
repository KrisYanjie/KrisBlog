package com.yj.login.utils;

import java.util.UUID;

public class IdUtils {
    /**
     * 获取随机UUID
     * @return
     */
    public static String randomUUID(){
        return UUID.randomUUID().toString();
    }

    /**
     * 获取去掉 "-" 的UUID
     * @return
     */
    public static String simpleUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
