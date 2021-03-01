package com.adroitwolf.mapper;

import com.adroitwolf.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName User.java
 * @Description 用户DAO接口
 * @createTime 2021年03月01日 08:56:00
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findUserByUsernameAndPassword(String username, String password);


}
