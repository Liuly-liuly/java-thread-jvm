package com.concurrency.chapter5;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadJoin2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1 is running");
                Thread.sleep(10_000);
                System.out.println("t1 is done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        try {
            t1.join(100,10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Optional.of("All of tasks finish done.").ifPresent(System.out::println);
        IntStream.range(1, 1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));

        //start httpServer
        //JettyHttpServer.start();

//        Thread.currentThread().join();
        String s = setValue();

        System.out.println("--->"+s);


    }


    public static String setValue(){
        Thread t1 = new Thread(() -> {

            System.out.println("t1 is running");
            try {
                TimeUnit.SECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            while (true) {
//                System.out.println(Thread.currentThread().isInterrupted());
//            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(10000);
                t1.interrupt();
                System.out.println("interrupt");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        t2.start();

        try {
            t2.join(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       return "string";
    }
}
