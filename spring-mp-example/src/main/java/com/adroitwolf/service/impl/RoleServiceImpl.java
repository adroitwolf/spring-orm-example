package com.adroitwolf.service.impl;

import com.adroitwolf.mapper.MenuMapper;
import com.adroitwolf.mapper.RoleMapper;
import com.adroitwolf.model.dto.DataGrid;
import com.adroitwolf.model.entity.Role;
import com.adroitwolf.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    public DataGrid<Role> getAllRoles(int pageNum, int pageSize) {
        //jpa 的分页是从0开始的


        Page<Role> page = new Page<>(pageNum,pageSize);

        IPage<Role> result = roleMapper.selectPage(page, new QueryWrapper<>());

        DataGrid<Role> dataGrid = new DataGrid<>();
        dataGrid.setTotal(result.getTotal());
        dataGrid.setRow(result.getRecords());
        return dataGrid;
    }

    @Override
    public List<Role> getAllRoles() {
        //todo 数据库操作
        return roleMapper.selectList(new QueryWrapper<>());
    }



}
