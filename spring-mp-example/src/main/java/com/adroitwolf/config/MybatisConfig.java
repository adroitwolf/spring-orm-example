package com.adroitwolf.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName MybatisConfig.java
 * @Description mp的配置文件
 * @createTime 2021年03月02日 08:27:00
 */
@Configuration
@MapperScan(basePackages = "com.adroitwolf.mapper")
public class MybatisConfig {

    /**
     * 分页配置
     * @return
     */
    @Bean
    public MybatisPlusInterceptor  mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        return interceptor;
    }
}
