package csc.lzp;

/**
 * 枚举类型的特性
 * 常量 放在方法区 共享区 值是不变的  (堆区)
 * 只能实例化一次,在加载的时候
 *
 * A,B,C,D是EnumDemo类型,是单例的
 */
public enum EnumDemo {
    A, B, C, D;

    public static void m1() {
        System.out.println("method");
    }

    public static void main(String[] args) {
        A.m1();
        B.m1();
        C.m1();
        D.m1();
        System.out.println(A.getClass().getName());
        System.out.println(B.getClass().getName());
        System.out.println(C.getClass().getName());
        System.out.println(D.getClass().getName());
    }
}
