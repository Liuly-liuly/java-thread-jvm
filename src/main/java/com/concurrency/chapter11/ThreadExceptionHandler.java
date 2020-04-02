package com.concurrency.chapter11;

import java.util.Arrays;
import java.util.Optional;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/12
 * @since JDK 1.8
 */
public class ThreadExceptionHandler {

    private final static int A = 10;
    private final static int B = 0;

    public static void main(String [] args){

        Thread th = new Thread(()->{
            try {
                Thread.sleep(5_000L);
                int result = A / B;
                System.out.println(result);
            } catch (Exception e) {

            }
        });

        th.setUncaughtExceptionHandler((t,s)->{
            System.out.println(s);
        });

        th.start();


    }
}
