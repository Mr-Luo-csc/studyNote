package csc.lzp;

/**
 * @Discription: 饿汉模式
 * 优缺点:
 * 线程安全性,数据一致性性;并发情况出现问题;ClassLoader类加载器
 * 性能;
 * 懒加载lazy 延迟加载 没有延迟加载,长时间不使用,影响性能,实例数据少(成员变量-内存消耗)的时候性能比较好,用到的时候再加载
 *
 * 在加载的时候就已经产生了
 * @Author: luozhipeng
 **/
public class HungrySingleton {

}
