package csc.lzp;

/**
 * @Discription: 静态类不类
 * /目前应用比较广泛的单例模式/
 * 实现了懒加载,并且没有加锁,效率更高
 * <init>同步方法,保证实例的唯一性
 * 自己的理解:饿汉式与懒汉式的结合
 * @Author: luozhipeng
 **/
public class HolderDemo {
    public HolderDemo() {
    }


    private static class Holder {
        private static HolderDemo holderDemo = new HolderDemo();
    }

    public static HolderDemo getInstance() {
        return Holder.holderDemo;
    }
}
