package com.adroitwolf.service;

import com.adroitwolf.model.entity.Role;
import com.querydsl.core.QueryResults;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName RoleService.java
 * @Description 角色服务
 * @createTime 2021年03月01日 11:47:00
 */
public interface RoleService {
    /**
     * 分页获取全部角色
     * @param pageNum
     * @param pageSize
     * @return
     */
    QueryResults<Role> getAllRoles(int pageNum, int pageSize);


    /**
     * 全量获取角色
     * @return
     */
    List<Role> getAllRoles();



}
