package com.adroitwolf.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName Menu.java
 * @Description 菜单实体类
 * @createTime 2021年03月01日 09:29:00
 */
@Data
public class Menu {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer  parentId;

    @TableField(exist = false)
    private boolean isChoose;
}
