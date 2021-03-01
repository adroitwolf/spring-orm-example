package com.adroitwolf.model.vo;

import com.adroitwolf.model.entity.Menu;
import lombok.Data;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName RoleMenuVo.java
 * @Description 与菜单视图相比，多了一个choose属性，这个属性主要定义当前菜单与角色的关系
 * @createTime 2021年03月01日 14:13:00
 */
@Data
public class RoleMenuVo {
    private Integer id;
    private Integer parentId;
    private String name;
    private boolean isChoose;
}
