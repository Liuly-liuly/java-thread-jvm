package com.concurrency.chapter12;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/12
 * @since JDK 1.8
 */
public class ThreadGroupApi {

    public static void main(String[] args){
        ThreadGroup tg1 = new ThreadGroup("TG1");
        Thread t1 = new Thread(tg1, "t1") {
            @Override
            public void run() {
                new Thread("thread-2") {
                    @Override
                    public void run() {
                        while (true) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start();
                while (true) {
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
            }
        };


//        Thread t2 = new Thread("t2"){
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(7_000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };

        //tg1.setDaemon(true);
        t1.start();
//        t2.start();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        //System.out.println(tg1.isDestroyed());
       // tg1.destroy();
        //System.out.println(tg1.isDestroyed());

        ThreadGroup tg2 = new ThreadGroup(tg1, "TG2");
        Thread t2 = new Thread(tg2, "T2") {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };

        t2.start();

        System.out.println(tg1.activeCount());
        System.out.println(tg1.activeGroupCount());
        t2.checkAccess();
        //tg1.destroy();

        System.out.println("=========================");
        Thread[] ts1 = new Thread[tg1.activeCount()];
        tg1.enumerate(ts1);
        Arrays.asList(ts1).forEach(System.out::println);

        System.out.println("=========================");
        tg1.enumerate(ts1, false);
        Arrays.asList(ts1).forEach(System.out::println);

        System.out.println("=========================");
        ts1 = new Thread[10];
        Thread.currentThread().getThreadGroup().enumerate(ts1, false);
        Arrays.asList(ts1).forEach(System.out::println);

//        tg1.interrupt();

    }

}
