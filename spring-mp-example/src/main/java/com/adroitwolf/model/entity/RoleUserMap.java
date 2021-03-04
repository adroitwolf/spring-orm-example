package com.adroitwolf.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName RoleUserMap.java
 * @Description 用户-角色关联实体类
 * @createTime 2021年03月01日 09:30:00
 */
@Data
public class RoleUserMap {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer roleId;

    private Integer userId;
}

