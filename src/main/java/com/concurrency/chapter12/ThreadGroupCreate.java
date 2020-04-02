package com.concurrency.chapter12;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/12
 * @since JDK 1.8
 */
public class ThreadGroupCreate {


    public static void main(String[] args){

        ThreadGroup tgs1 = new ThreadGroup("TGS1");

        new Thread(tgs1 ,()->{
         //while (true){
//             System.out.println(Thread.currentThread().getThreadGroup().getName());
//             System.out.println(Thread.currentThread().getThreadGroup().getParent());
//             System.out.println(Thread.currentThread().getPriority());
             try {
                 Thread.sleep(10000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         //}
        },"t1").start();


        ThreadGroup tg2 = new ThreadGroup("TG2");
        Thread t2 = new Thread(tg2, "T2") {
            @Override
            public void run() {
//                System.out.println(">>>"+tgs1.getName());
//                Thread[] threads = new Thread[tgs1.activeCount()];
//                tgs1.enumerate(threads);
//                Arrays.asList(threads).forEach(System.out::println);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        t2.start();


        System.out.println(tg2.getName());
        System.out.println(tg2.getParent());
//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getThreadGroup().getName());

        Thread[] enums = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(enums);
        Arrays.asList(enums).forEach(System.out::println);
    }

}
