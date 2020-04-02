package com.concurrency.chapter6;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/7
 * @since JDK 1.8
 */
public class ThreadInterrupt {

    public static void main(String [] args){
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {

                }
            }
        };

        t.start();
        Thread main = Thread.currentThread();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(12000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                main.interrupt();
                System.out.println("interrupt");
            }
        };

        t2.start();
        try {
            System.out.println("please enter waitSet .....");
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
