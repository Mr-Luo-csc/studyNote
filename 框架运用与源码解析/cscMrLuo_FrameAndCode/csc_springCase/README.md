# springCode spring框架案例 模拟
# 模拟spring整合mybatis 动态给容器中添加bean

**给mapper的接口上加上@Repository，无法生成相应的bean,从而无法@Autowired，这是因为spring扫描注解时，自动过滤掉了接口和抽象类，这种情况下可以在启动的类前加上@MapperScan(从而使mapper可以自动注入，但是idea还会提示bean无法找到，但是不会影响运行)**

*spring会另外解析这三个类(特别)*
- normal
- importSelector
- importBeanDefinitionRegister

**添加bean到bean工厂(bean工厂建设)**

*问题*

- A类(A-bean) extends CardService 会自动注入给我们的CardService吗?——不会——自动装配
- A类(A-bean) implement CardService 会自动注入给我们的CardService吗?——会——自动装配
- ⚠️mybatis知识点 <bean>mapper注册给我们的factoryBean</bean> 
- mybatis中提供两种mapper注册的方式:1、使用@mapperScan注解;2、写mybatis.xml手动添加

+ step1: object
+ step2: implement cardDao
+ step3: spring map 容器

接口变成对象: 使用代理