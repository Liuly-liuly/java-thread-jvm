package com.concurrency.chapter5;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @version 1.0
 * @since JDK 1.8
 */
public class ThreadJoin {

    public static void main(String[]args) {
        Thread t1 = new Thread(()->{
            IntStream.range(1,100).forEach(i->{
                System.out.println(Thread.currentThread().getName()+"-->"+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });

        Thread t2 = new Thread(()->{
            IntStream.range(1,100).forEach(i->{
                System.out.println(Thread.currentThread().getName()+"-->"+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                }
            });
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.currentThread().interrupt();
        Optional.of("all work finished").ifPresent(System.out::println);
    }


}
