package com.adroitwolf.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName JpaConfig.java
 * @Description TODO
 * @createTime 2021年03月02日 11:36:00
 */

@Configuration
public class JpaConfig {

    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager) {
        return new JPAQueryFactory(entityManager);
    }
}
