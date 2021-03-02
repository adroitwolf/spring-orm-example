package com.adroitwolf.service;


import com.adroitwolf.model.dto.DataGrid;
import com.adroitwolf.model.entity.User;
import com.adroitwolf.model.vo.MenuVo;
import com.adroitwolf.model.vo.UserDetails;
import com.adroitwolf.model.vo.UserRoleMapVo;
import com.adroitwolf.service.MenuService;
import com.adroitwolf.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName UserServiceTest.java
 * @Description 用户service测试
 * @createTime 2021年03月01日 10:05:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;


    @Autowired
    MenuService menuService;

    /**
     * 登陆测试
     */
    @Test
    public void loginTest(){
        UserDetails details = userService.loginByUsername("wolf", "123");
        System.out.println(details.toString());
    }



    @Test
    public void getAllUsers(){
        DataGrid<User> users = userService.getAllUserByPage(1, 3);

        users.getRow().forEach(System.out::println);
    }



    @Test
    public void getMenuByUserId(){
        List<MenuVo> menus = menuService.getMenuByUserId(2);
        menus.forEach(System.out::println);
    }




    @Test
    public void getRolesMapByUserId(){
        List<UserRoleMapVo> mapByUserId = userService.getRolesMapByUserId(1);
        mapByUserId.forEach(System.out::println);
    }


    @Test
    public void updateRolesByUserId(){
        List<Integer> rolesId = new ArrayList<>();
        rolesId.add(2);
        userService.saveRolesMapByUserId(rolesId,1);
    }
}
