package com.adroitwolf.model.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.ColumnType;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName Menu.java
 * @Description 菜单实体类
 * @createTime 2021年03月01日 09:29:00
 */
@Data
public class Menu {
    private Integer id;

    private String name;

    @ColumnType(column="parent_id")
    private Integer  parentId;
}
