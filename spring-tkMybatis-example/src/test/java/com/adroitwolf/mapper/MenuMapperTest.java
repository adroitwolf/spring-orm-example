package com.adroitwolf.mapper;

import com.adroitwolf.model.entity.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName MenuMapperTest.java
 * @Description TODO
 * @createTime 2021年03月02日 09:56:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuMapperTest {

    @Autowired
    MenuMapper menuMapper;

    @Test
    public void findAllByUserId(){
        menuMapper.findAllByUserId(1).forEach(System.out::println);
    }

    @Test
    public void findAllByRoleId(){
        menuMapper.findAllByRoleId(1).forEach(System.out::println);
    }
}
