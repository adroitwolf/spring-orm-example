package com.adroitwolf.model.entity;

import lombok.Data;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName RoleMenuMap.java
 * @Description 角色-菜单关联实体类
 * @createTime 2021年03月01日 09:28:00
 */
@Data
public class RoleMenuMap {
    private Integer id;

    private Integer roleId;
    private Integer menuId;
}
