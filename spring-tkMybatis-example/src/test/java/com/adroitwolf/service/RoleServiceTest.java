package com.adroitwolf.service;

import com.adroitwolf.model.dto.DataGrid;
import com.adroitwolf.model.entity.Role;
import com.adroitwolf.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
        DataGrid<Role> roles = roleService.getAllRoles(1, 5);

        long totalElements = roles.getTotal();
        System.out.println("total:"+totalElements);
        System.out.println("======================");
        roles.getRow().forEach(System.out::println);
    }
}
