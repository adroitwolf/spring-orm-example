package com.adroitwolf.service;

import com.adroitwolf.model.entity.Role;
import com.querydsl.core.QueryResults;
import java.util.List;
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
        QueryResults<Role> roles = roleService.getAllRoles(1, 5);
        long total = roles.getTotal();
        List<Role> list = roles.getResults();
        System.out.println("total:"+total);
        System.out.println("contents:"+list);
        System.out.println("======================");
        list.forEach(System.out::println);
    }
}
