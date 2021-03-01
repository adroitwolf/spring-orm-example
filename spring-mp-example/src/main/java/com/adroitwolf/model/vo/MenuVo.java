package com.adroitwolf.model.vo;

import com.adroitwolf.model.entity.Menu;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName MenuVo.java
 * @Description 菜单视图 -> 暂时只定义了二层菜单
 * @createTime 2021年03月01日 10:24:00
 */
@Data
@ToString(callSuper = true)
public class MenuVo {

    private Integer id;
    private Integer parentId;
    private String name;

    private List<Menu> subMenu;
}
