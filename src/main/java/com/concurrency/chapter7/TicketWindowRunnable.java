package com.concurrency.chapter7;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/7
 * @since JDK 1.8
 */
public class TicketWindowRunnable implements Runnable {

    private int index = 1;

    private final static int MAX = 500;

    private final Object MONITOR = new Object();

    @Override
    public void run() {

        while (true) {
            //1
            synchronized (this) {
                if (index > MAX)
                    break;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
            }
            //2
        }
    }
}