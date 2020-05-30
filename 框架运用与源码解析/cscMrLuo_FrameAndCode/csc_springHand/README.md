#手写模拟一个springIOC

- 使用dom4j解析xml文件的形式,获取里面的bean,然后通过编码的方式实现bean之间的依赖关系
- 构造方法注入、setter注入、自动注入

**自动注入(包括以下三种方式)**
- @Autowired注解——由spring提供
- @Resource注解——由JSR-250提供
- @Inject注解——由JSR-330提供

绑定远程的GitHub账号

GitLab的自动部署

注入bean优先级的问题
- spring当中 手动装配的优先级高于自动装配?

**beanFactory与factoryBean的区别**

逻辑一定要屡一遍才开始写代码🆗

### 了解以下每日U货的app端的需求

**数据结构就是用来描述数据的**

**beanFactory  &  factoryBean**

- xml 声明和扫描
- 注解 只是声明 没有扫描
- register() 加了javaConfig的bean,在config类上加scan 普通的bean直接加单个的bean,例如xxService.class
- refresh()
- @profile() 先实例化 然后再设置条件

**spring中是使用 AnnotatedGenericDefinition类来存bean的完整信息的 相当与一个数据结构**
