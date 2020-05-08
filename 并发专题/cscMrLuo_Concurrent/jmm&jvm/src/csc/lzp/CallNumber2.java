package csc.lzp;

/**
 * @Discription:
 * @Author: luozhipeng
 **/
public class CallNumber2 implements Runnable {
    static int ticket = 500;
    final static int index = 0;

    @Override
    public void run() {
        System.out.println("剩余票数: " + ticket);
    }

    public synchronized void sell() {
        ticket--;
    }

    public static void main(String[] args) {
        CallNumber2 callNumber2 = new CallNumber2();
        for (int i = 0; i < 1000; i++) {
            if (ticket == index) {
                break;
            }
            new Thread(callNumber2::sell).start();
            System.out.println("当前线程为: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("CPU或线程异常");
            }
        }
    }
}
