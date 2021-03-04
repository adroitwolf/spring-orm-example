package com.adroitwolf.service.impl;

import com.adroitwolf.model.entity.*;
import com.adroitwolf.model.vo.UserDetails;
import com.adroitwolf.service.UserService;
import com.github.aqiu202.starters.jpa.query.dsl.JPAQueryExecutor;
import com.querydsl.core.QueryResults;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2021年03月01日 09:25:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    JPAQueryExecutor jpaQueryExecutor;

    @Override
    public UserDetails loginByUsername(String username, String password) {
        Optional<User> user = Optional.ofNullable(
                jpaQueryExecutor.selectFrom(QUser.user).where(QUser.user.username.eq(username))
                        .fetchOne());

        UserDetails details = new UserDetails();
        if (!user.isPresent() || !user.get().getPassword().equals(password)) { // 空则直接返回
            return details;
        }

        BeanUtils.copyProperties(user.get(), details);

        QRole qRole = QRole.role;
        QRoleUserMap qRoleUserMap = QRoleUserMap.roleUserMap;
        List<Role> fetch = jpaQueryExecutor.select(qRole)
                .from(qRoleUserMap)
                .leftJoin(qRole)
                .on(qRoleUserMap.roleId.eq(qRole.id))
                .where(qRoleUserMap.userId.eq(details.getId()))
                .fetch();

        details.setRoles(fetch);

        return details;
    }

    @Override
    public QueryResults<User> getAllUserByPage(int pageNum, int pageSize) {
        return jpaQueryExecutor.selectFrom(QUser.user)
                .pageable(PageRequest.of(pageNum - 1, pageSize)).fetchResults();
    }

    @Override
    public List<Role> getRolesMapByUserId(Integer userId) {
        List<Role> roles = jpaQueryExecutor.selectFrom(QRole.role).fetch();

        // 获取用户所拥有的roleID,
        final QRoleUserMap qRoleUserMap = QRoleUserMap.roleUserMap;

        List<Integer> rolesId = jpaQueryExecutor.select(qRoleUserMap.roleId).from(qRoleUserMap)
                .where(qRoleUserMap.userId.eq(userId)).fetch(); // 查询数据库

        return roles.stream().map(item -> {
            item.setChoose(rolesId.contains(item.getId()));
            return item;
        }).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public void saveRolesMapByUserId(List<Integer> roles, Integer userId) {
        // 删除掉所有的角色Id
        this.jpaQueryExecutor.delete(QRoleUserMap.roleUserMap)
                .where(QRoleUserMap.roleUserMap.userId.eq(userId)).execute();

        // 新增
        List<RoleUserMap> list = roles.stream().map(roleId -> {
            RoleUserMap roleUserMap = new RoleUserMap();
            roleUserMap.setUserId(userId);
            roleUserMap.setRoleId(roleId);
            return roleUserMap;
        }).collect(Collectors.toList());

        jpaQueryExecutor.save(list);
    }


}
