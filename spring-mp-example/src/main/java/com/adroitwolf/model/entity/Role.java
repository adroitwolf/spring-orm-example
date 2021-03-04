package com.adroitwolf.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String name;

    private String nameZh;

    @TableField(exist = false)
    private boolean isChoose;
}
