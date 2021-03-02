package com.adroitwolf.repository;

import com.adroitwolf.model.entity.RoleMenuMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName RoleMenuMaprepository.java
 * @Description 角色-菜单关联 DAO
 * @createTime 2021年03月01日 14:21:00
 */
public interface RoleMenuMapRepository extends JpaRepository<RoleMenuMap,Integer> {

    List<RoleMenuMap> findRoleMenuMapsByRoleId(Integer roleId);



    void deleteRoleMenuMapsByRoleId(Integer roleId);
}
