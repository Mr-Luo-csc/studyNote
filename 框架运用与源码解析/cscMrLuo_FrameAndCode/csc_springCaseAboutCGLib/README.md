# spring 中@config注解 解析 CGLib代理 案例

**动态代理**

- JDK动态代理:直接操作字节码
- CGLib代理:使用ASM框架操作字节码,操作更加复杂

<b>疑问</b>
- 使用@Mapper与@@Repository这两者有什么去区别?区别: 是否需要使用@MapperScan;两者都标注在Dao接口上

>@Repository需要在Spring中配置扫描地址,然后生成Dao层的Bean才能被注入到Service层中
>
>@Mapper不需要配置扫描地址,通过xml里面的namespace里面的接口地址,生成了Bean后注入到Service层中
>
>@MapperScan是@Mapper的简化,不再需要每个Dao都加上@Mapper注解

- spring生命周期的回调(这里有两个注解)
- spring bean 实例化过程中的循环引用怎么实现的?
- 什么是有使用@import?什么时候使用@importRegistar?
