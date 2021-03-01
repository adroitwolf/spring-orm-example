package com.adroitwolf.mapper;

import com.adroitwolf.model.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Optional;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName User.java
 * @Description 用户DAO接口
 * @createTime 2021年03月01日 08:56:00
 */
public interface UserMapper extends BaseMapper<User> {

    Optional<User> findUserByUsernameAndPassword(String username, String password);


}
