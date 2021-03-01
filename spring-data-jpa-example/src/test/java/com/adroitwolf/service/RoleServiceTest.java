package com.adroitwolf.service;

import com.adroitwolf.model.entity.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName RoleServiceTest.java
 * @Description TODO
 * @createTime 2021年03月01日 12:47:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

    @Autowired
    RoleService roleService;

    @Test
    public void getAllRoles(){
        Page<Role> roles = roleService.getAllRoles(1, 5);
        int totalPages = roles.getTotalPages();
        long totalElements = roles.getTotalElements();
        System.out.println("total:"+totalElements);
        System.out.println("page:"+totalPages);
        System.out.println("======================");
        roles.get().forEach(System.out::println);
    }
}
