package com.adroitwolf.mapper;

import com.adroitwolf.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName RoleRepository.java
 * @Description 角色DAO
 * @createTime 2021年03月01日 09:50:00
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {

    @Query(value = "select r.* from role_user_map as rum left join role as r on rum.role_id = r.id where rum.user_id = :id ",nativeQuery = true)
    List<Role> findAllByUserId(@Param("id") Integer userId);
}
