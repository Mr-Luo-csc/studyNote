# JDK的代理

**静态代理**
- 继承 
- 聚合

**动态代理**
- 字符串到一个实例对象的过程
 
 ~~csc MotherFukerJump!!!~~
 
**Java中一切皆是对象,构造方法可以构造成一个对象**

- JDK和ASM都是操作byte[]字节码,将byte[]字节码转换成一个代理对象的
- 在JVM中操作的其实是classLoader加载Class之后生成的byte[]字节码,byte[]转换成一个实例对象的过程
- JDK动态代理,底层使用的API是native本地方法栈当中的,底层是用c、c++来实现的