package com.concurrency.chapter4;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;


public class DaemonThread2 {
    public static void main(String[] args) {

        Thread t = new Thread(new ThreadGroup("innerThread"),() -> {
            Thread innerThread = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("Do some thing for health check.");
                        Thread.sleep(10000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"test");

            //innerThread.setDaemon(true);
            innerThread.start();

            //System.out.println(innerThread.getThreadGroup().getParent());
            //System.out.println(innerThread.getPriority());

            try {
                Thread.sleep(100000);
                System.out.println("T thread finish done.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t-t-t");
        t.setDaemon(true);
        t.start();

        try {
            System.out.println(t.getPriority());
            Thread.currentThread().getThreadGroup().list();
            Thread.currentThread().join(60000);
            System.out.println("---->main over .....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
