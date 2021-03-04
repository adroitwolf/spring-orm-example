package com.adroitwolf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName SpringStartApplication.java
 * @Description 启动入口
 * @createTime 2021年03月01日 08:36:00
 */
@MapperScan(basePackages = "com.adroitwolf.mapper")
@SpringBootApplication
public class TkMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TkMybatisApplication.class,args);
    }
}
