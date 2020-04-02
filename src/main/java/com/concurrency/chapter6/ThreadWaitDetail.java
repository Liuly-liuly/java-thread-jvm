package com.concurrency.chapter6;

import javafx.beans.binding.ObjectExpression;
import sun.plugin2.main.client.MessagePassingOneWayJSObject;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/6
 * @since JDK 1.8
 */
public class ThreadWaitDetail {

    private static volatile Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {
       /* Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (MONITOR) {
                        try {
                            MONITOR.wait(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println(isInterrupted());
                        }
                    }
                }
            }
        };

        Thread tt = new Thread(() -> {
            while (true) {
                synchronized (MONITOR) {
                    try {
                        MONITOR.wait(70);
                        System.out.println("tt is tarting ");
                       while (true){
                          // System.out.println("--->");
                       }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println(Thread.interrupted());
                    }
                }
            }
        });

        //这个时候根本无法把 t打断然而t 处于block状态
        t.start();
        tt.start();
        Thread.sleep(150);
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());*/


        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (MONITOR) {
                        try {
                            //time_waiting 转态 ----> blocked
                            MONITOR.wait(600);//只想等这个监视器600毫秒我就要走了
                            //但是往下走的时候发现拿不到锁，就进入blocked状态
                            //等别人释放锁，拿到了锁你以为它会在wait 600毫秒嘛？
                            //实际上是不会的 ，blocked 住会再次去抢锁往下走
                            System.out.println("---->");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println(isInterrupted());
                        }
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                 synchronized (MONITOR){
//                     try {
//
//                         Thread.sleep(1200);
//                     } catch (InterruptedException e) {
//                         e.printStackTrace();
//                     }
//                        System.out.println("=====打断=====");
                     try {
                         Thread.sleep(1200);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     System.out.println("=====通知=====");
                        //MONITOR.notify();
                 }
                }
            }
        };

        t.start();
        t2.start();
        Thread.sleep(500);
        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());


    }
}
