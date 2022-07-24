package com.yj.login.constant;

/**
 * @author kris
 * @version 1.0
 * @date 2022/7/24 23:39
 */
public class RedisPrefixConst {
    /**
     * 验证码过期时间
     */
    public static final long CODE_EXPIRE_TIME = 15 * 60;

    /**
     * 验证码
     */
    public static final String USER_CODE_KEY = "code:";

    /**
     * 博客浏览量
     */
    public static final String BLOG_VIEWS_COUNT="blog_views_count";

    /**
     * 网站配置
     */
    public static final String WEBSITE_CONFIG="website_config";
}
