package com.adroitwolf.service;

import com.adroitwolf.model.entity.Menu;
import com.adroitwolf.model.vo.MenuVo;
import com.adroitwolf.model.vo.RoleMenuMapVo;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName MenuService.java
 * @Description 菜单服务
 * @createTime 2021年03月01日 10:22:00
 */
public interface MenuService {
    /**
     * 通过角色id获取到当前角色的所有菜单
     * @param roleId
     * @return
     */
    List<MenuVo> getMenuByRoleId(Integer roleId);


    /**
     * 通过用户id获取到当前用户的所有菜单
     * @param userId
     * @return
     */
    List<MenuVo> getMenuByUserId(Integer userId);

    /**
     * 获取到所有菜单
     * @return
     */
    List<Menu> getAllMenus();

    /**
     * 通过角色id，获取到所有菜单和角色id之间的关系
     * @param roleId
     * @return
     */
    List<RoleMenuMapVo> getAllMenuMapByRoleId(Integer roleId);


    /**
     * 更新所有菜单和角色id之间的关系
     * @param roleId
     */
    void saveMenusMapByRoleId(List<Integer> menus,Integer roleId);
}
