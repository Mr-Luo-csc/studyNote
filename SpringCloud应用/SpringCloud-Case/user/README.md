# user模块

- 调用power和order模块,两个微服务使用不用的负载均衡策略
- 模拟一个Ribbon的负载均衡策略

**注意**
添加IRule的配置类不能放在application启动类的包下

------

**hystrix断路器**

_出错原因(程序出BUG):_

- 数据库没有正确的查询条件
- 缓存击穿
- 响应过慢
- ...

_解决方案:_

- 方法降级
- 超时监听
- 服务熔断
- 服务限流

------

**feign整合hystrix的使用**

- yml中配置开启feign对hystrix的支持,高版本的springCloud默认把这个支持关闭了
- feign的方法降解粒度是微服务级别的