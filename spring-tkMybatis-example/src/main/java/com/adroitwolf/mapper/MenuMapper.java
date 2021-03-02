package com.adroitwolf.mapper;


import com.adroitwolf.model.entity.Menu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

    @Select(value = "select m.* from role_menu_map as rmm left join menu as m on m.id = rmm.menu_id where rmm.role_id = #{id} ")
    List<Menu> findAllByRoleId(@Param("id") Integer roleId);


    @Select(value = "select m.* from role_user_map as rum left join  role_menu_map as rmm  on rmm.role_id = rum.role_id  left join menu as m on m.id = rmm.menu_id where rum.user_id = #{id} ")
    List<Menu> findAllByUserId(@Param("id") Integer userId);

}
