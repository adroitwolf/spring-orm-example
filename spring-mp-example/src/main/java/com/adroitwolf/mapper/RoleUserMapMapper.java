package com.adroitwolf.mapper;

import com.adroitwolf.model.entity.RoleUserMap;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName RoleUserMaprepository.java
 * @Description jpa中没有update操作，只有save操作
 * @createTime 2021年03月01日 13:10:00
 */
public interface RoleUserMapMapper extends BaseMapper<RoleUserMap> {
    void deleteAllByUserId(Integer userId);
    List<RoleUserMap> findRoleUserMapsByUserId(Integer userId);
}
