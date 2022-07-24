package com.yj.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yj.login.dto.BlogHomeInfoDTO;
import com.yj.login.entity.Article;
import com.yj.login.mapper.ArticleMapper;
import com.yj.login.mapper.CategoryMapper;
import com.yj.login.mapper.TagMapper;
import com.yj.login.service.BlogInfoService;
import com.yj.login.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static com.yj.login.constant.CommonConst.*;
import static com.yj.login.constant.RedisPrefixConst.*;
import static com.yj.login.enums.ArticleStatusEnum.PUBLIC;

public class BlogInfoServiceImpl implements BlogInfoService {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    TagMapper tagMapper;
    @Autowired
    RedisService redisService;
    @Override
    public BlogHomeInfoDTO getBlogHomeInfo() {
    //查询文章数量
        Integer articleCount = articleMapper.selectCount(new LambdaQueryWrapper<Article>()
                .eq(Article::getStatus, PUBLIC.getStatus())
                .eq(Article::getIsDelete, FALSE));
    //查询分类数量
        categoryMapper.selectCount(null)
        //查询标签数量
        Integer tagCount = tagMapper.selectCount(null);
    //查询访问量
        Object count = redisService.get(BLOG_VIEWS_COUNT);
        String viewsCount = Optional.ofNullable(count).orElse(0).toString();
        //查询网站配置

        //查询页面图片

    //封装数据
    }
}
