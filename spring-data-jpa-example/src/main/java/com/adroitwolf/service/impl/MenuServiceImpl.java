package com.adroitwolf.service.impl;

import com.adroitwolf.model.entity.Menu;
import com.adroitwolf.model.entity.RoleMenuMap;
import com.adroitwolf.model.vo.MenuVo;
import com.adroitwolf.model.vo.RoleMenuMapVo;
import com.adroitwolf.model.vo.RoleMenuVo;
import com.adroitwolf.mapper.MenuRepository;
import com.adroitwolf.mapper.RoleMenuMapRepository;
import com.adroitwolf.service.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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
    MenuRepository menuRepository;


    @Autowired
    RoleMenuMapRepository roleMenuMapRepository;

    @Override
    public List<MenuVo> getMenuByRoleId(Integer roleId) {
        List<Menu> menus = menuRepository.findAllByRoleId(roleId);
        return adjustMenu(menus);

    }

    @Override
    public List<MenuVo> getMenuByUserId(Integer userId) {
        List<Menu> menus = menuRepository.findAllByUserId(userId);

        return adjustMenu(menus);
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public List<RoleMenuMapVo> getAllMenuMapByRoleId(Integer roleId) {
        //先获取所有菜单
        List<Menu> menus = menuRepository.findAll();
        // 获取所有该角色应该有的菜单
        List<Integer> menusId = roleMenuMapRepository.findRoleMenuMapsByRoleId(roleId).stream().map(RoleMenuMap::getMenuId).collect(Collectors.toList());


        List<RoleMenuVo> lists = menus.stream().map(item->{
            RoleMenuVo roleMenuVo = new RoleMenuVo();
            BeanUtils.copyProperties(item,roleMenuVo);
            roleMenuVo.setChoose(menusId.contains(item.getId()));
            return roleMenuVo;
        }).collect(Collectors.toList());

        return adjustMenuMap(lists);
    }

    @Override
    public void saveMenusMapByRoleId(List<Integer> menus,Integer roleId) {
        roleMenuMapRepository.deleteRoleMenuMapsByRoleId(roleId); //先删除


        // 新增
        List<RoleMenuMap> list = menus.stream().map(menuId->{
            RoleMenuMap roleMenuMap = new RoleMenuMap();
            roleMenuMap.setMenuId(menuId);
            roleMenuMap.setRoleId(roleId);
            return roleMenuMap;
        }).collect(Collectors.toList());
            roleMenuMapRepository.saveAll(list);
    }


    private List<RoleMenuMapVo> adjustMenuMap(List<RoleMenuVo> menus){
        if(menus.size() ==0){
            return Collections.EMPTY_LIST;
        }



        HashMap<Integer,RoleMenuMapVo> map = new HashMap<>();
        menus.stream().filter(s-> s.getParentId() == 0).forEach(item->{ //创建第一层菜单
            RoleMenuMapVo menuVo = new RoleMenuMapVo();

            BeanUtils.copyProperties(item,menuVo);
            menuVo.setSubMenus(new ArrayList<>());
            map.put(item.getId(),menuVo);
        });



        menus.stream().filter(s->s.getParentId() != 0).forEach(item->{ //获取二层菜单
            RoleMenuMapVo parent = map.get(item.getParentId());
            List<RoleMenuVo> subMenu = parent.getSubMenus();
            subMenu.add(item);
            parent.setSubMenus(subMenu);
            map.replace(item.getParentId(),parent);
        });

        return  new ArrayList<>(map.values());
    }


    private List<MenuVo> adjustMenu(List<Menu> menus){
        if(menus.size() ==0){
            return Collections.EMPTY_LIST;
        }



        HashMap<Integer,MenuVo> map = new HashMap<>();
        menus.stream().filter(s-> s.getParentId() == 0).forEach(item->{ //创建第一层菜单
            MenuVo menuVo = new MenuVo();

            BeanUtils.copyProperties(item,menuVo);
            menuVo.setSubMenu(new ArrayList<>());
            map.put(item.getId(),menuVo);
        });



        menus.stream().filter(s->s.getParentId() != 0) .forEach(item->{ //获取二层菜单
            MenuVo parent = map.get(item.getParentId());
            List<Menu> subMenu = parent.getSubMenu();
            subMenu.add(item);
            parent.setSubMenu(subMenu);
            map.replace(item.getParentId(),parent);
        });

        return new ArrayList<>(map.values());

    }
}
