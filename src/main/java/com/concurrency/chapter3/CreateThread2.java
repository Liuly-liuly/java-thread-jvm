package com.concurrency.chapter3;

import java.util.Arrays;


public class CreateThread2 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        //由谁创建就属于哪个线程组
        System.out.println(t.getThreadGroup());
        System.out.println(Thread.currentThread().getName());
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.getName());

        System.out.println(threadGroup.activeCount());

//        threadGroup.list();
//        Thread[] threads = new Thread[threadGroup.activeCount()];
//        threadGroup.enumerate(threads);
//
//        Arrays.asList(threads).forEach(System.out::println);
    }
}
