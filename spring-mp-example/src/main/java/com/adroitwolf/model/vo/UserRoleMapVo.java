package com.adroitwolf.model.vo;

import lombok.Data;
import lombok.ToString;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName UserRoleMapVo.java
 * @Description 与角色实体类相比，多了一个角色与用户是否相关的属性
 * @createTime 2021年03月01日 13:28:00
 */
@Data
@ToString
public class UserRoleMapVo {
    private Integer id;

    private String name;

    private String nameZh;

    private boolean isChoose; // 用户是否拥有该角色



}
