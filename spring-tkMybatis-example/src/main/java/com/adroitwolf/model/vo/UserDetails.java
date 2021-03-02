package com.adroitwolf.model.vo;

import com.adroitwolf.model.entity.Role;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName UserDetails.java
 * @Description 角色详情
 * @createTime 2021年03月01日 09:26:00
 */
@Data
@ToString
public class UserDetails {
    private Integer id;

    private String username;

    List<Role> roles;

}
