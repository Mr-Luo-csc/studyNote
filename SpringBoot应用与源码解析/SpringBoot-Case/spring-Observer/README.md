# spring-event

**spring的事件**

- 启动-ContextStartedEvent
- 停止-ContextStoppedEvent
- 刷新-ContextRefreshedEvent
- 关闭-ContextClosedEvent

**springboot是怎样实现web项目的**

- addWebApp() `这个时候需要添加JSP依赖`
- addContext() `这时候不需要添加JSP依赖,并且不会扫描MATA-INFO文件夹中配置的文件`