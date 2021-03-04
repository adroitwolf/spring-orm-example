package com.adroitwolf.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName Menu.java
 * @Description 菜单实体类
 * @createTime 2021年03月01日 09:29:00
 */
@Data
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private Integer  parentId;

    @Transient
    private boolean isChoose;
}
