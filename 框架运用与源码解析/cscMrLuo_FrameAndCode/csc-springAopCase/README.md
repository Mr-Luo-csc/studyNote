# springAOP的解析

- springAop Demo
- 不同用户使用不同的Dao
- importWare的使用 Redis案例 `使用注解注入属性` [使用注解注入属性]
- 几个PostProcessor的使用 Check这个确定有没有使用注解
- spring中属性自动装配的类型 会剔除哪些属性,spring这里有条件塞选

# how to flare mr-luo

------

- FactoryMethod
- UniqueFactoryMethod
- IsStatic判断是否是static的方法
- 某个类不要spring去自动装配属性就放到bean容器中

- 判断有参还是无参构造方法创建实例 无参构造方法Spring默认是0
- 两个isSingleton()方法的作用

------

**一般在Spring中配置工厂Bean,有3中不同类型的工厂Bean的配置**

- 静态工厂
- 实例工厂
- 实现FactoryBean接口 `加"&"返回工厂Bean的实例`

```xml
<!--将其纳入Spring容器来管理,需要通过factory-method指定静态方法名称-->
<!--createRandom方法必须是static的,才能找到-->
<bean id="random" class="csc.lzp.StaticFactoryBean" factory-method="createRandom" scope="prototype"/>
```

```xml
<bean id="instanceFactoryBean" class="example.chapter3.InstanceFactoryBean">
<property name="format" value="yyyy-MM-dd HH:mm:ss"/>
</bean>

<bean id="currentTime" factory-bean="instanceFactoryBean" factory-method="createTime"/>
```