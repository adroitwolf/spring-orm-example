package com.adroitwolf.mapper;

import com.adroitwolf.model.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName Menurepository.java
 * @Description 菜单DAO
 * @createTime 2021年03月01日 10:16:00
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> findAllByRoleId(Integer roleId);

    List<Menu> findAllByUserId(@Param("id")Integer userId);
}
