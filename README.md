# spring-orm-example

-----------

## 个人总结

1. spring data jpa 和 mybatis plus的体验比tkMybatis的体验相对好一点

2. tk mybatis 的MapperScan注解需要弄成自己的、自动映射做的都不是很好，需要Mybatis自己开启设置

3. 其次，关于QueryDSL的使用，个人感觉和Spring security差不多，对代码侵入性极大。但是还是有他的
优点的，就是他干掉了任何orm都头疼的多表查询功能，真正让项目实现了面向对象编程，让之后的sql代码维护变得有条理了一些。
