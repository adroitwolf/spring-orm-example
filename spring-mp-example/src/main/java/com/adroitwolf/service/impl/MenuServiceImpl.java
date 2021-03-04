package com.adroitwolf.service.impl;

import com.adroitwolf.mapper.MenuMapper;
import com.adroitwolf.mapper.RoleMenuMapMapper;
import com.adroitwolf.model.entity.Menu;
import com.adroitwolf.model.entity.RoleMenuMap;
import com.adroitwolf.service.MenuService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName MenuServiceImpl.java
 * @Description TODO
 * @createTime 2021年03月01日 10:26:00
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;


    @Autowired
    RoleMenuMapMapper roleMenuMapMapper;

    @Override
    public List<Menu> getMenuByRoleId(Integer roleId) {
        return menuMapper.findAllByRoleId(roleId);
    }

    @Override
    public List<Menu> getMenuByUserId(Integer userId) {

        return menuMapper.findAllByUserId(userId);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public List<Menu> getAllMenuMapByRoleId(Integer roleId) {
        //先获取所有菜单
        List<Menu> menus = menuMapper.selectList(null);
        // 获取所有该角色应该有的菜单
        QueryWrapper<RoleMenuMap> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",roleId);
        List<Integer> menusId = roleMenuMapMapper.selectList(wrapper).stream().map(RoleMenuMap::getMenuId).collect(Collectors.toList());

        return menus.stream().map(item->{

            item.setChoose(menusId.contains(item.getId()));
            return item;
        }).collect(Collectors.toList());
    }

    @Override
    public void saveMenusMapByRoleId(List<Integer> menus,Integer roleId) {
        QueryWrapper<RoleMenuMap> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",roleId);
        roleMenuMapMapper.delete(wrapper); //先删除

        // 新增
         menus.stream().forEach(menuId->{
            RoleMenuMap roleMenuMap = new RoleMenuMap();
            roleMenuMap.setMenuId(menuId);
            roleMenuMap.setRoleId(roleId);
            // mp的mapper接口不支持批量插入
            roleMenuMapMapper.insert(roleMenuMap);
        });


    }

}
