package com.adroitwolf.service.impl;


import com.adroitwolf.mapper.RoleMapper;
import com.adroitwolf.mapper.RoleUserMapMapper;
import com.adroitwolf.mapper.UserMapper;
import com.adroitwolf.model.dto.DataGrid;
import com.adroitwolf.model.entity.Role;
import com.adroitwolf.model.entity.RoleUserMap;
import com.adroitwolf.model.entity.User;
import com.adroitwolf.model.vo.UserDetails;
import com.adroitwolf.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2021年03月01日 09:25:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleUserMapMapper roleUserMapMapper;

    @Override
    public UserDetails loginByUsername(String username, String password) {

        User wrapper = new User();
        wrapper.setUsername(username);
        User user = userMapper.selectOne(wrapper);

        Assert.notNull(user,"未找到该用户");

        UserDetails details = new UserDetails();

        if(!user.getPassword().equals(password)){
            return details;
        }

        BeanUtils.copyProperties(user,details);
        details.setRoles(roleMapper.findAllByUserId(details.getId()));

        return details;
    }

    @Override
    public DataGrid<User> getAllUserByPage(int pageNum, int pageSize) {
        // 分页
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.selectAll();

        PageInfo<User> results = new PageInfo<>(users);
        DataGrid<User> dataGrid = new DataGrid<>();
        dataGrid.setTotal(results.getTotal());
        dataGrid.setRow(results.getList());
        return dataGrid;
    }

    @Override
    public List<Role> getRolesMapByUserId(Integer userId) {
        List<Role> roles = roleMapper.selectAll();

        // 获取用户所拥有的roleID

        RoleUserMap wrapper = new RoleUserMap();
        wrapper.setUserId(userId);
        List<Integer> rolesId = roleUserMapMapper.select(wrapper).stream().map(RoleUserMap::getRoleId).collect(Collectors.toList());

        return roles.stream().map(item->{
            item.setChoose(rolesId.contains(item.getId()));
            return item;
        }).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public void saveRolesMapByUserId(List<Integer> roles, Integer userId) {
        // 删除掉所有的角色Id

        RoleUserMap wrapper = new RoleUserMap();
        wrapper.setUserId(userId);
        roleUserMapMapper.delete(wrapper);

        // 新增
        roles.forEach(roleId->{
            RoleUserMap roleUserMap = new RoleUserMap();
            roleUserMap.setUserId(userId);
            roleUserMap.setRoleId(roleId);
            roleUserMapMapper.insert(roleUserMap);
        });
    }


}
