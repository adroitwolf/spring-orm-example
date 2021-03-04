package com.adroitwolf.service.impl;

import com.adroitwolf.mapper.MenuMapper;
import com.adroitwolf.mapper.RoleMapper;
import com.adroitwolf.model.entity.Role;
import com.adroitwolf.service.RoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName RoleServiceImpl.java
 * @Description TODO
 * @createTime 2021年03月01日 11:47:00
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;

    @Autowired
    MenuMapper menuMapper;



    @Override
    public IPage<Role> getAllRoles(int pageNum, int pageSize) {
        //jpa 的分页是从0开始的

        Page<Role> page = new Page<>(pageNum,pageSize);

        IPage<Role> result = roleMapper.selectPage(page, null);

        return result;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.selectList(null);
    }



}
