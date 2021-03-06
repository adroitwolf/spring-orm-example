package com.adroitwolf.mapper;

import com.adroitwolf.model.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName RoleRepository.java
 * @Description 角色DAO
 * @createTime 2021年03月01日 09:50:00
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> findAllByUserId(@Param("id") Integer id);
}
