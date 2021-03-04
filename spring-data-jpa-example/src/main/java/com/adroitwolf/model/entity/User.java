package com.adroitwolf.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName User.java
 * @Description 用户实体类
 * @createTime 2021年03月01日 09:00:00
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "is_enabled")
    private String isEnabled;


}
