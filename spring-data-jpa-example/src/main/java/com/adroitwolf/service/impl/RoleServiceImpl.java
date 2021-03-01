package com.adroitwolf.service.impl;

import com.adroitwolf.model.entity.Role;
import com.adroitwolf.mapper.MenuRepository;
import com.adroitwolf.mapper.RoleRepository;
import com.adroitwolf.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    RoleRepository roleRepository;

    @Autowired
    MenuRepository menuRepository;



    @Override
    public Page<Role> getAllRoles(int pageNum, int pageSize) {
        //jpa 的分页是从0开始的
        return roleRepository.findAll(PageRequest.of(pageNum-1,pageSize));
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }



}
