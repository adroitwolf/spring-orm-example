package com.adroitwolf.service.impl;

import com.adroitwolf.mapper.RoleMapper;
import com.adroitwolf.mapper.RoleUserMapMapper;
import com.adroitwolf.mapper.UserMapper;
import com.adroitwolf.model.entity.Role;
import com.adroitwolf.model.entity.RoleUserMap;
import com.adroitwolf.model.entity.User;
import com.adroitwolf.model.vo.UserDetails;
import com.adroitwolf.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
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
    public IPage<User> getAllUserByPage(int pageNum, int pageSize) {
        Page<User> page = new Page<>(pageNum, pageSize);
        return userMapper.selectPage(page,new QueryWrapper<>());
    }

    @Override
    public List<Role> getRolesMapByUserId(Integer userId) {
        List<Role> roles = roleMapper.selectList(null);

        // 获取用户所拥有的roleID
        QueryWrapper<RoleUserMap> mapQueryWrapper = new QueryWrapper<>();
        mapQueryWrapper.eq("user_id",userId);
        List<RoleUserMap> roleMapsByUserId = roleUserMapMapper.selectList(mapQueryWrapper);

        List<Integer> rolesId = roleMapsByUserId.stream().map(RoleUserMap::getRoleId).collect(Collectors.toList());

        return roles.stream().map(item->{

            item.setChoose(rolesId.contains(item.getId()));

            return item;
        }).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public void saveRolesMapByUserId(List<Integer> roles, Integer userId) {
        // 删除掉所有的角色Id
        UpdateWrapper<RoleUserMap> wrapper = new UpdateWrapper<>();
        wrapper.eq("user_id",userId);
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
