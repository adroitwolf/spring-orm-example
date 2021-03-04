package com.adroitwolf.mapper;

import com.adroitwolf.model.entity.Role;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName RoleRepository.java
 * @Description 角色DAO
 * @createTime 2021年03月01日 09:50:00
 */
public interface RoleMapper extends Mapper<Role> {

    List<Role> findAllByUserId(@Param("id") Integer userId);
}
