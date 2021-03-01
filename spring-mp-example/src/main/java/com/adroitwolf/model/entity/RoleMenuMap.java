package com.adroitwolf.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName RoleMenuMap.java
 * @Description 角色-菜单关联实体类
 * @createTime 2021年03月01日 09:28:00
 */
@Data
@TableName(value = "role_menu_map")
public class RoleMenuMap {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer roleId;
    private Integer menuId;
}
