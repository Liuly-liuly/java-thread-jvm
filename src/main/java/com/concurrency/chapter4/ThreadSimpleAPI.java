package com.concurrency.chapter4;

import java.util.Optional;


public class ThreadSimpleAPI {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Optional.of("Hello").ifPresent(System.out::println);
            try {
                Thread.sleep(100_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        t.start();
        Optional.of(t.getName()).ifPresent(System.out::println);
        Optional.of(t.getId()).ifPresent(System.out::println);
        Optional.of("--->"+t.getThreadGroup().getParent()).ifPresent(System.out::println);
        t.getThreadGroup().list();
    }
}
