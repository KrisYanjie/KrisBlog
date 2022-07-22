package com.yj.login.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yj.login.entity.Menu;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;


import java.util.List;
/**
 * @author kris
 * @version 1.0
 * @date 2022/7/23 0:09
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    /**
     * 根据用户id查询菜单
     * @param userInfoId 用户信息id
     * @return 菜单列表
     */
    List<Menu> listMenusByUserInfoId(Integer userInfoId);

}
