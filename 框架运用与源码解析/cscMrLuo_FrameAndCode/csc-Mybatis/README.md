# mybatis框架源码

- mybatis
- mybatis-spring
- sqlSessionTemplate增强,这边关闭了session导致了一级缓存失效

**Java8新特性**

- 某类实现接口,可以不实现接口中的方法

- JUL的日志级别是INFO级别的 其它日志框架的级别是根据配置文件中配置的
- Mybatis打印日志是DEBUG级别的日志,所以我们使用JUL实现的时候,不会打印SQL

**Mybatis底层源码**

- 先存到Map,然后之后再到Map中拿sql #?
- 代理模式 MappperFactoryBean SqlSessionTemplate 两个代理类
- no byType byName 自动注入的区别
- 自动注入的属性,有几个条件判断的,会过滤一些要注入的属性,最终还是看set方法,有set方法的属性会自动注入
- write对应set
- read对应get