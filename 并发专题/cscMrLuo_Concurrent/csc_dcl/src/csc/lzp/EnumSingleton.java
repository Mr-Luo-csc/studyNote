package csc.lzp;

/**
 * 神仙操作
 * 保证线程的安全性
 * 不保证懒加载
 * 跟饿汉式相似
 */
public enum EnumSingleton {
    INSTANCE;

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
