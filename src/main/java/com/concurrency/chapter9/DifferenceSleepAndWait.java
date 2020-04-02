package com.concurrency.chapter9;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/8
 * @since JDK 1.8
 */
public class DifferenceSleepAndWait {

    private static final Object monitor = new Object();

    public static void main(String[] args){

        Stream.of("M1","M2").forEach(i->{
            new Thread(i){
                @Override
                public void run() {
                    sleepTest();
                }
            }.start();
        });


        Stream.of("T1","T2").forEach(i->{
            new Thread(i){
                @Override
                public void run() {
                    waitTest();
                }
            }.start();
        });

    }

    public static void sleepTest(){

        synchronized (monitor){
            Optional.of("sleep method [10000] seconds").ifPresent(System.out::println);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void waitTest(){
        synchronized (monitor){
            Optional.of("wait method is waiting").ifPresent(System.out::println);
            try {
                monitor.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
