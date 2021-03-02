package com.adroitwolf.repository;

import com.adroitwolf.model.entity.Role;
import com.adroitwolf.mapper.RoleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName repositoryTest.java
 * @Description TODO
 * @createTime 2021年03月01日 10:00:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTest {
    @Autowired
    RoleRepository repository;
    @Test
    public void RoleTest(){
        List<Role> roles = repository.findAllByUserId(1);

        roles.stream().forEach(System.out::println);
    }
}
