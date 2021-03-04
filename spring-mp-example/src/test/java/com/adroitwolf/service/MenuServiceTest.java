package com.adroitwolf.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName MenuServiceTest.java
 * @Description TODO
 * @createTime 2021年03月01日 11:10:00
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuServiceTest {
    @Autowired
    MenuService menuService;


    @Test
    public void getMenusByUserId(){
        menuService.getMenuByUserId(1).forEach(System.out::println);
    }


    @Test
    public void getAllMenus(){
        menuService.getAllMenus().forEach(System.out::println);
    }


    @Test
    public void getAllMenusMap(){
        menuService.getAllMenuMapByRoleId(2).forEach(System.out::println);
    }
}
