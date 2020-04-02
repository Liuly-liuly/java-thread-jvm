package com.concurrency.chapter4;

public class DaemonThread {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread() {

            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " running");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }; //new
        //设置后台线程必须要在start 方法前
        t.setDaemon(true);

        t.start();
        //java.lang.IllegalThreadStateException
        //t.setDaemon(true);
        //runnable  ->running| ->dead| ->blocked

        System.out.println(Thread.currentThread().getName());
        t.join();   //JDK1.7

    }
}

/**
 * A<---------------------------------->B
 *  ->daemonThread(health check)
 * */