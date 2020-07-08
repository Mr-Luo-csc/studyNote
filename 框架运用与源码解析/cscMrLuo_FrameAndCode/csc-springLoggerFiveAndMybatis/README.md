# spring5 底层日志框架 Mybatis日志框架

**maven插件中可以生成依赖导图关系**

- spring5使用的是JCl,不过是修改过JCl源码的,命名spring-jcl
- spring-jcl中,实现是用 switch case 来实现的

**spring5新特性**

- 使用了Java8
- 使用了lambe表达式
- 重新实现了spring自己的jcl

------

**Mybatis**

- spring-jdbc: spring自己的数据库连接池 不推荐使用c3p0
- mybatis 打印日志 方式一:配置mybatis-config.xml 方式二:log4j配置文件中加一行代码添加代理打印
- 日志:在sqlSessionFactory中配置设置日志框架实现;在config类中添加@post方法初始化打印日志;在Spring初始化上下文时设置
- mybatis 一级缓存:结合spring框架的时候失效了,sqlSessionFactory由spring控制;基于单个用户的缓存
- mybatis 二级缓存:基于命名空间,在同一命名空间才有效
