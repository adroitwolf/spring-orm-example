package com.adroitwolf.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName RoleUserMap.java
 * @Description 用户-角色关联实体类
 * @createTime 2021年03月01日 09:30:00
 */
@Data
@Entity
@Table(name = "role_user_map")
public class RoleUserMap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增
    @Column(name = "id")
    private Integer id;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "user_id")
    private Integer userId;
}

