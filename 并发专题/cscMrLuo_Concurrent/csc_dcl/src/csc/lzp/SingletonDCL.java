package csc.lzp;

/**
 * @Discription: DCL double checked Locking ？？？double Lock?!Go Dancing～～～
 * @Author: luozhipeng
 **/
public class SingletonDCL {

    private String init = "";
    private Object object = null;
    //加volatile防止指令重排,导致实例化成员变量失败
    private volatile static SingletonDCL singletonDCL = null;

    /**
     * 构造方法私有化
     */
    private SingletonDCL() {
        this.init = "luozhipeng";
        this.object = new Object();
    }

    public static SingletonDCL getInstance() {
        if (null == singletonDCL) {
            synchronized (SingletonDCL.class) {
                if (null == singletonDCL) {
                    singletonDCL = new SingletonDCL();
                }
            }
        }
        return singletonDCL;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println("SingletonDCL对象的地址: " + SingletonDCL.getInstance());
            }).start();

        }
    }

}
