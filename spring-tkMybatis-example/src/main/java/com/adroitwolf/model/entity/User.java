package com.adroitwolf.model.entity;

import lombok.Data;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName User.java
 * @Description 用户实体类
 * @createTime 2021年03月01日 09:00:00
 */
@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    private String email;
    private String phone;

    private String isEnabled;


}
