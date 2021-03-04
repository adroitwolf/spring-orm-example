package com.adroitwolf.service.impl;

import com.adroitwolf.model.entity.QRole;
import com.adroitwolf.model.entity.Role;
import com.adroitwolf.service.RoleService;
import com.github.aqiu202.starters.jpa.query.dsl.JPAQueryExecutor;
import com.querydsl.core.QueryResults;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName RoleServiceImpl.java
 * @Description TODO
 * @createTime 2021年03月01日 11:47:00
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    JPAQueryExecutor jpaQueryExecutor;

    @Override
    public QueryResults<Role> getAllRoles(int pageNum, int pageSize) {
        //jpa 的分页是从0开始的
        return this.jpaQueryExecutor.selectFrom(QRole.role)
                .pageable(PageRequest.of(pageNum - 1, pageSize)).fetchResults();
    }

    @Override
    public List<Role> getAllRoles() {
        return jpaQueryExecutor.selectFrom(QRole.role).fetch();
    }


}
