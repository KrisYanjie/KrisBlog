package com.yj.login.controller;

import com.yj.login.dto.BlogHomeInfoDTO;
import com.yj.login.service.BlogInfoService;
import com.yj.login.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 博客信息控制器
 *
 * @author kris
 * @date2022/07/22
 */

@Api(tags = "博客信息模块")

public class BlogInfoController {

    @Autowired
    private BlogInfoService blogInfoService;
    /**
     * 查看博客信息
     *
     * @return {@link Result<BlogHomeInfoDTO>} 博客信息
     */
    @ApiOperation(value = "查看博客信息")
    @GetMapping("/")
    public Result<BlogHomeInfoDTO> getBlogHomeInfo(){
            return Result.ok(blogInfoService.getBlogHomeInfo());
    }



}
