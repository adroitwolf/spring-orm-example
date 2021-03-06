package com.adroitwolf;

import com.github.aqiu202.starters.jpa.anno.EnableBaseJpaRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author adroitwolf
 * @version 1.0.0
 * @ClassName SpringStartApplication.java
 * @Description 启动入口
 * @createTime 2021年03月01日 08:36:00
 */
@SpringBootApplication
@EnableBaseJpaRepositories
public class SpringStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringStartApplication.class,args);
    }
}
