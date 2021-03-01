package com.adroitwolf.mapper;

import com.adroitwolf.model.entity.RoleUserMap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName RoleUserMaprepository.java
 * @Description jpa中没有update操作，只有save操作
 * @createTime 2021年03月01日 13:10:00
 */
public interface RoleUserMapRepository extends JpaRepository<RoleUserMap,Integer> {
    void deleteAllByUserId(Integer userId);
    List<RoleUserMap> findRoleUserMapsByUserId(Integer userId);
}
