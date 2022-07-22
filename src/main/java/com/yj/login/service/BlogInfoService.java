package com.yj.login.service;

import com.yj.login.dto.BlogHomeInfoDTO;

/**
 * @author kris
 * @date   2022/07/22
 */
public interface BlogInfoService {

    /**
     * 获取首页数据
     *
     * @return 博客首页信息
     */
    BlogHomeInfoDTO getBlogHomeInfo();
}
