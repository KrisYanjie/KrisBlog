package com.yj.login.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yj.login.dto.ResourceRoleDTO;
import com.yj.login.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: kris
 * @version: 1.0
 * @create: 2022-07-05 15:26
 **/
@Repository
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 查询路由角色列表
     *
     * @return 角色标签
     */
    List<ResourceRoleDTO> listResourceRoles();

    /**
     * 根据用户id获取角色列表
     *
     * @param userInfoId 用户id
     * @return 角色标签
     */
    List<String> listRolesByUserInfoId(Integer userInfoId);
}
