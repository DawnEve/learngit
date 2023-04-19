leanr Spring 6
======================

子模块1 spring-first
子模块2 spring6-ioc-xml
	v0.1.0@spring eclipse下的maven项目，引入spring6; 手动在xml中配置bean信息
	v0.1.1@spring log4j2 记录日志
	v0.1.2@spring 依赖注入IoC和DI
	v0.1.3@spring 注入对象类型
	v0.1.4@spring 注入数组类型
	v0.1.5@spring fix: employee
	v0.1.6@spring 注入List类型
	v0.1.7@spring 注入Map类型; 引用注入，p命名空间
	v0.1.8@spring 引入外部属性文件，完成value的值注入
	v0.1.9@spring bean 作用域
	v0.2.0@spring bean 生命周期
	v0.2.1@spring FactoryBean: 常用于整合第三方框架
	v0.2.2@spring 基于xml自动装配，autowire="byType"
子模块3 spring6-ioc-anno
		每新增一个子模块，最外层的 pom.xml 就自动增加一行 <module>spring6-ioc-annotation</module>
	v0.2.3@spring 基于注解的自动装配、属性注入
	v0.2.4@spring @Autowired 注入方法：6种方式
	v0.2.5@spring @Resource 注入
	v0.2.6@spring 全注解开发：使用注解类
	v0.2.6-2@spring fix
	v0.2.6-3@spring fix
子模块4 spring6-reflect
	v0.2.7@spring 手写IoC：回顾反射
子模块5 mio-ioc
	v0.2.8@spring 手写IoC: 注解+反射 创建对象，放到IoC容器中
	v0.2.9@spring 手写IoC: 实现属性注入
子模块6 spring6-aop
	v0.3.0@spring 静态代理，动态代理
	v0.3.1@spring 基于注解的AOP
	v0.3.2@spring 切入点表达式 重用; 基于xml的AOP
	v0.3.3@spring spring 整合 JUnit5
	v0.3.4@spring spring 整合 JUnit4: 运行失败：不报错，不输出
子模块7 spring6-jdbc-tx  事务
```
create database spring;

use spring;

create table `t_emp`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`name` varchar(20) DEFAULT NULL COMMENT '姓名',
	`age` int(11) DEFAULT NULL COMMENT '年龄',
	`gender` varchar(2) DEFAULT NULL COMMENT '性别',
	PRIMARY KEY(`id`) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
	v0.3.5@spring JdbcTemplate 实现新增数据
	v0.3.6@spring JdbcTemplate 增删改查
	v0.3.7@spring 买书程序，余额不够时可能出错: 库存-1，用户余额不变
	v0.3.8@spring 买书程序，余额不够时可能出错: 加事务后，库存不变，用户余额不变
	v0.3.9@spring @Transactional的参数：Spring 事务的只读、超时、隔离级别、传播行为
	v0.4.0@spring 全注解配置事务
	v0.4.1@spring 基于 xml 的声明式事务管理
子模块8 spring6-resources
	v0.4.2@spring Resource 接口及其实现类
	v0.4.3@spring ResourceLoader 接口及其实现类
	v0.4.4@spring 资源作为属性注入
	v0.4.5@spring 应用程序上下文和资源路径：资源通配符
子模块9 spring6-i18n
	v0.4.6@spring java 国际化
	v0.4.7@spring Spring6 的国际化
子模块10 spring6-validator
	v0.4.8@spring Spring6 数据校验: 基于 Validator 接口的校验; 基于 Validation 注解
	v0.4.9@spring Spring6 数据校验: 基于方法的校验
	v0.5.0@spring Spring6 数据校验: 自定义校验方法





