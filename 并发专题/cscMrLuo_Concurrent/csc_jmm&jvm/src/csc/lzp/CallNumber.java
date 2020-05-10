package csc.lzp;


/**
 * @Discription: 多个窗口叫号、不重号、不跳号
 * @Author: luozhipeng
 **/
public class CallNumber {
    static int ticket = 9;//票数
    final static int index = 0;//零界点

    //修饰方法
    public synchronized void sell() {
        ticket--;//非原子性操作
        System.out.println("当前线程: " + Thread.currentThread().getName() + "|  票数剩余: " + ticket);
    }

    public static void main(String[] args) {
        CallNumber callNumber = new CallNumber();

        for (int i = 0; i < 10; i++) {//时间片,cpu交替使用线程
            if (ticket == index) {
                break;
            }
            new Thread(callNumber::sell).start();

//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                //JDK1.6 CAS算法 决定锁的粒度大小
//                System.out.println("线程异常的时候,可以去释放锁!");
//            }
        }

    }
}
