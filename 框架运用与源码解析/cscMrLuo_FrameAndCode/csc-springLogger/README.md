# spring的日志体系

- log4j 
- JUL 
- JCL 选取log4j和JUL两者实现

spring4用的是log4j

spring5用的不是log4j

**beanUtils浅拷贝**

- 可以减少setter操作,直接赋值

------

**日志框架**

- 反射 构造器 newInstance
- jar冲突,导入jar中有其它修改过后的jar依赖
- 绑定器
- 路由器
- 日志体系、缓存体系