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

`Java字节码编译框架 ASM`

自己定义通过URLClassLoader来实现的动态代理,有IO操作,非常消耗性能

例如:redis使用多路复用的思想进行非阻塞的IO,保证了redis的高效性

.Java文件就是Java源文件


#反射

- 类的类对象 是对你的Class文件进行修饰的对象
- 类的对象 表示的是你所去"通过属性"修饰的一个实例对象