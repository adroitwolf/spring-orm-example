package com.adroitwolf.service.impl;

import com.adroitwolf.model.entity.*;
import com.adroitwolf.service.MenuService;
import com.github.aqiu202.starters.jpa.query.dsl.JPAQueryExecutor;
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
    JPAQueryExecutor jpaQueryExecutor;

    @Override
    public List<Menu> getMenuByRoleId(Integer roleId) {
        final QMenu qMenu = QMenu.menu;
        final QRoleMenuMap roleMenuMap = QRoleMenuMap.roleMenuMap;

        return jpaQueryExecutor.select(qMenu)
                .from(roleMenuMap)
                .leftJoin(qMenu)
                .on(roleMenuMap.roleId.eq(qMenu.id))
                .where(roleMenuMap.roleId.eq(roleId))
                .fetch();
    }

    @Override
    public List<Menu> getMenuByUserId(Integer userId) {
        final QMenu qMenu = QMenu.menu;
        final QRoleUserMap qRoleUserMap = QRoleUserMap.roleUserMap;
        final QRoleMenuMap qRoleMenuMap = QRoleMenuMap.roleMenuMap;
        return jpaQueryExecutor.select(qMenu)
                .from(qRoleUserMap)
                .leftJoin(qRoleMenuMap)
                .on(qRoleMenuMap.roleId.eq(qRoleUserMap.roleId))
                .leftJoin(qMenu)
                .on(qMenu.id.eq(qRoleMenuMap.menuId))
                .where(qRoleUserMap.userId.eq(userId))
                .fetch();
    }

    @Override
    public List<Menu> getAllMenus() {
        return this.jpaQueryExecutor.selectFrom(QMenu.menu).fetch();
    }

    @Override
    public List<Menu> getAllMenuMapByRoleId(Integer roleId) {
        //先获取所有菜单
        List<Menu> menus = this.jpaQueryExecutor.selectFrom(QMenu.menu).fetch();
        // 获取所有该角色应该有的菜单
        final QRoleMenuMap rmm = QRoleMenuMap.roleMenuMap;
        List<Integer> menusId = jpaQueryExecutor.select(rmm.menuId).from(rmm).where(rmm.roleId.eq(roleId))
                .fetch();

        return menus.stream().map(item -> {
            //添加当前用户是否拥有的标识
            item.setChoose(menusId.contains(item.getId()));
            return item;
        }).collect(Collectors.toList());

    }

    @Override
    public void saveMenusMapByRoleId(List<Integer> menus, Integer roleId) {
        final QRoleMenuMap rmm = QRoleMenuMap.roleMenuMap;
        jpaQueryExecutor.delete(rmm).where(rmm.roleId.eq(roleId)).execute(); //先删除

        // 新增
        List<RoleMenuMap> list = menus.stream().map(menuId -> {
            RoleMenuMap roleMenuMap = new RoleMenuMap();
            roleMenuMap.setMenuId(menuId);
            roleMenuMap.setRoleId(roleId);
            return roleMenuMap;
        }).collect(Collectors.toList());
        this.jpaQueryExecutor.save(list);
    }
}
