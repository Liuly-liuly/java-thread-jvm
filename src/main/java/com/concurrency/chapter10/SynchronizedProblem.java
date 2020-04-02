package com.concurrency.chapter10;

public class SynchronizedProblem {

    public static void main(String[] args) throws InterruptedException {

        new Thread("t1") {
            @Override
            public void run() {
                SynchronizedProblem.sleep();
            }
        }.start();

        Thread.sleep(1000);

        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
//                /sdfsdfsd
                SynchronizedProblem.run();
                //sdfsdfsd
            }
        };
        t2.start();
        Thread.sleep(10000);
        t2.interrupt();
        System.out.println(t2.isInterrupted());
    }

    private synchronized static void run() {
        System.out.println(Thread.currentThread());
        while (true) {

        }
    }

    private synchronized static void sleep() {
        System.out.println(Thread.currentThread());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
