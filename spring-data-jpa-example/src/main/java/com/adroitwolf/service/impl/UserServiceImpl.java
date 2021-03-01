package com.adroitwolf.service.impl;

import com.adroitwolf.model.entity.Role;
import com.adroitwolf.model.entity.RoleUserMap;
import com.adroitwolf.model.entity.User;
import com.adroitwolf.model.vo.UserDetails;
import com.adroitwolf.model.vo.UserRoleMapVo;
import com.adroitwolf.mapper.RoleRepository;
import com.adroitwolf.mapper.RoleUserMapRepository;
import com.adroitwolf.mapper.UserRepository;
import com.adroitwolf.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    RoleUserMapRepository roleUserMaprepository;

    @Override
    public UserDetails loginByUsername(String username, String password) {
        Optional<User> user = userRepository.findUserByUsernameAndPassword(username, password);

        if(!user.isPresent()){ // 空则直接返回
            return null;
        }

        UserDetails details = new UserDetails();

        BeanUtils.copyProperties(user.get(),details);

        details.setRoles(roleRepository.findAllByUserId(details.getId()));


        return details;
    }

    @Override
    public Page<User> getAllUserByPage(int pageNum, int pageSize) {
        return userRepository.findAll(PageRequest.of(pageNum-1,pageSize));
    }

    @Override
    public List<UserRoleMapVo> getRolesMapByUserId(Integer userId) {
        List<Role> roles = roleRepository.findAll();

        // 获取用户所拥有的roleID

        List<RoleUserMap> roleMapsByUserId = roleUserMaprepository.findRoleUserMapsByUserId(userId);

        List<Integer> rolesId = roleMapsByUserId.stream().map(RoleUserMap::getRoleId).collect(Collectors.toList());

        //
        return roles.stream().map(item->{
            UserRoleMapVo roleMapVo = new UserRoleMapVo();

            roleMapVo.setChoose(rolesId.contains(item.getId()));

            BeanUtils.copyProperties(item,roleMapVo);
            return roleMapVo;
        }).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public void saveRolesMapByUserId(List<Integer> roles, Integer userId) {
        // 删除掉所有的角色Id
        roleUserMaprepository.deleteAllByUserId(userId);


        // 新增
        List<RoleUserMap> list = roles.stream().map(roleId->{
            RoleUserMap roleUserMap = new RoleUserMap();
            roleUserMap.setUserId(userId);
            roleUserMap.setRoleId(roleId);
            return roleUserMap;
        }).collect(Collectors.toList());

        roleUserMaprepository.saveAll(list);
    }


}
