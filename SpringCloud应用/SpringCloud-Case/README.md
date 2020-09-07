# 使用springCloud实现的微服务应用

**spring cloud 把各个组件相互配合起来,整合成一套成熟的微服务架构体系**

- `Eureka`:::做服务注册与发现,很好的把各个服务链接起来
- `Ribbon+Feign`:::提供了微服务的调用和负载均衡解决方案
- `Hystrix`:::负责监控微服务之间的调用情况,以及降级和熔断保护
- `Hystrix-Dashboard`:::监控Hystrix的熔断情况以及监控信息以图形化界面展示
- `Spring-Cloud-Config`:::提供了统一的配置中心服务
- `Zuul`:::所有外来的请求由zuul统一进行路由和转发，起到了API网关的作用
- `Sleuth+Zipkin`:::把我们微服务的追踪数据记录下来并展示方便我们进行后续分析