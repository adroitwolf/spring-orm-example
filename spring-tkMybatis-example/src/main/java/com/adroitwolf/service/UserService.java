package com.adroitwolf.service;


import com.adroitwolf.model.dto.DataGrid;
import com.adroitwolf.model.entity.Role;
import com.adroitwolf.model.entity.User;
import com.adroitwolf.model.vo.UserDetails;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description 用户服务层
 * @createTime 2021年03月01日 09:24:00
 */

public interface UserService {

    /**
     * 登录功能
     * @param username
     * @param password
     * @return
     */
    UserDetails loginByUsername(String username, String password);

    /**
     * 查询所有角色
     * @param pageNum
     * @param pageSize
     * @return
     */
    DataGrid<User> getAllUserByPage(int pageNum, int pageSize);


    /**
     * 查询到该用户能被赋予的所有角色，其中拥有当前该用户是否已经拥有该用户的具体标识
     * @param userId
     * @return
     */
    List<Role> getRolesMapByUserId(Integer userId);


    /**
     * 更新用户所拥有的用户
     * @param roles
     * @param userId
     */
    void saveRolesMapByUserId(List<Integer> roles,Integer userId);

}
