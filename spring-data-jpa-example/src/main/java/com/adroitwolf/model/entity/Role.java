package com.adroitwolf.model.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName Role.java
 * @Description 角色实体类
 * @createTime 2021年03月01日 09:27:00
 */
@Data
@ToString
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "name_zh")
    private String nameZh;

    @Transient
    private boolean isChoose; // 用户是否拥有该角色
}
