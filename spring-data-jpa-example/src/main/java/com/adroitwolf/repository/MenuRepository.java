package com.adroitwolf.repository;

import com.adroitwolf.model.entity.Menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName Menurepository.java
 * @Description 菜单DAO
 * @createTime 2021年03月01日 10:16:00
 */
public interface MenuRepository extends JpaRepository<Menu,Integer>, QuerydslPredicateExecutor<Menu> {

//    @Query(nativeQuery = true,value = "select m.* from role_menu_map as rmm left join menu as m on m.id = rmm.menu_id where rmm.role_id = :id ")
//    List<Menu> findAllByRoleId(@Param("id")Integer roleId);


//    @Query(nativeQuery = true,value = "select m.* from role_user_map as rum left join  role_menu_map as rmm  on rmm.role_id = rum.role_id  left join menu as m on m.id = rmm.menu_id where rum.user_id = :id ")
//    List<Menu> findAllByUserId(@Param("id")Integer userId);
}
