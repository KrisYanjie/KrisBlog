package com.yj.login.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.yj.login.dto.LabelOptionDTO;
import com.yj.login.dto.MenuDTO;
import com.yj.login.dto.UserMenuDTO;
import com.yj.login.entity.Menu;
import com.yj.login.vo.ConditionVO;
import com.yj.login.vo.MenuVO;

import java.util.List;

/**
 * 菜单service
 *
 * @Author 古丶野
 * @Date 2021/12/13 21:39
 * @Version 2.0
 */

public interface MenuService extends IService<Menu> {
    /**
     * 查看菜单列表
     *
     * @param conditionVO 条件
     * @return 菜单列表
     */
    List<MenuDTO> listMenus(ConditionVO conditionVO);

    /**
     * 新增或修改菜单
     *
     * @param menuVO 菜单信息
     */
    void saveOrUpdateMenu(MenuVO menuVO);

    /**
     * 删除菜单
     *
     * @param menuId 菜单id
     */
    void deleteMenu(Integer menuId);

    /**
     * 查看角色菜单选项
     *
     * @return 角色菜单选项
     */
    List<LabelOptionDTO> listMenuOptions();

    /**
     * 查看用户菜单
     *
     * @return 菜单列表
     */
    List<UserMenuDTO> listUserMenus();
}