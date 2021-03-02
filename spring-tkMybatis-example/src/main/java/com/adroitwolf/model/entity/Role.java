package com.adroitwolf.model.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName Role.java
 * @Description 角色实体类
 * @createTime 2021年03月01日 09:27:00
 */
@Data
@ToString
public class Role {

    private Integer id;

    private String name;

    private String nameZh;
}
