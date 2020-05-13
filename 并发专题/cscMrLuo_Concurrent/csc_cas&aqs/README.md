并发专题 CAS和AQS

锁: 封锁
    悲观锁、写(增删改)多,读(查)少 引起数据不一致问题 Lock机制 加锁
    乐观过 版本控制(版本控件)

JUC Java并发包

CompareAndSet / CompareAndSwap 比较和交换 Java体系结构 指令 一种无锁的原子算法 一种乐观锁

CAS(V,E,N)V代表拿到的值 E代表预期的值 N代表修改之后的值

CAS 无锁

AQS 实现自己的锁

并发集合