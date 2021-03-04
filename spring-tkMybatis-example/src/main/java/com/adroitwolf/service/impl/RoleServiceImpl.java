package com.adroitwolf.service.impl;


import com.adroitwolf.mapper.MenuMapper;
import com.adroitwolf.mapper.RoleMapper;
import com.adroitwolf.model.dto.DataGrid;
import com.adroitwolf.model.entity.Role;
import com.adroitwolf.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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



        PageHelper.startPage(pageNum,pageSize);
        List<Role> result = roleMapper.selectAll();
        PageInfo<Role> pageInfoObject = new PageInfo<>(result);


        DataGrid<Role> dataGrid = new DataGrid<>();
        dataGrid.setTotal(pageInfoObject.getTotal());
        dataGrid.setRow(pageInfoObject.getList());
        return dataGrid;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleMapper.selectAll();
    }



}
