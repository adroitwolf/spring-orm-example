package com.adroitwolf.mapper;


import com.adroitwolf.model.entity.Menu;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName Menurepository.java
 * @Description 菜单DAO
 * @createTime 2021年03月01日 10:16:00
 */
public interface MenuMapper extends Mapper<Menu> {

    List<Menu> findAllByRoleId(@Param("id") Integer roleId);

    List<Menu> findAllByUserId(@Param("id") Integer userId);

}
