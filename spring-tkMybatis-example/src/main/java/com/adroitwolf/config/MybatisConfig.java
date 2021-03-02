package com.adroitwolf.config;
//这里不能导入原生的mapperscan
import tk.mybatis.spring.annotation.MapperScan;
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


}
