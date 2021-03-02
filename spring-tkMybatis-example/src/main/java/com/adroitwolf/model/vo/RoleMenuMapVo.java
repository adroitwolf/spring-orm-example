package com.adroitwolf.model.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName RoleMenuMapVo.java
 * @Description 与菜单视图相比，多了一个choose属性，这个属性主要定义当前菜单与角色的关系
 * @createTime 2021年03月01日 14:30:00
 */
@Data
@ToString
public class RoleMenuMapVo {
    private Integer id;
    private Integer parentId;
    private String name;
    private boolean isChoose;
    List<RoleMenuVo> subMenus;
}
