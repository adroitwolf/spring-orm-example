package com.adroitwolf.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName RoleMenuMap.java
 * @Description 角色-菜单关联实体类
 * @createTime 2021年03月01日 09:28:00
 */
@Data
@Entity
@Table(name = "role_menu_map")
public class RoleMenuMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增
    @Column(name = "id")
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "menu_id")
    private Integer menuId;
}
