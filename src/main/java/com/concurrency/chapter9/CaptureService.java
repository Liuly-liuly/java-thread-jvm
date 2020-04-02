package com.concurrency.chapter9;

import org.omg.CORBA.DATA_CONVERSION;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/7
 * @since JDK 1.8
 */
public class CaptureService {

    private static LinkedList<String> data = new LinkedList<>();

    private static int MAX = 5;

    public static void main(String[] args) {

        List<Thread> worker = new ArrayList<>();

        Arrays.asList("M1", "M2", "M3", "M4", "M5", "M6").stream()
                .map(CaptureService::createTh).forEach(i -> {
            i.start();
            worker.add(i);
        });

        worker.stream().forEach(i->{
            try {
                i.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

    private static Thread createTh(String name) {

        return new Thread(() -> {
            synchronized (data) {
                while (data.size() >= MAX) {
                    try {
                        data.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Optional.of("[thread name " + Thread.currentThread().getName() +
                        " ] begin produce data").ifPresent(System.out::println);

                data.add(new String("producer"+data.size()));
            }

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Optional.of("The Worker name [ " + Thread.currentThread().getName() +
                    " ] start to consume").ifPresent(System.out::println);
            synchronized (data) {
                if (!data.isEmpty()) {
                    String s = data.removeFirst();
                    Optional.of(Thread.currentThread().getName() +
                            " consume "+s).ifPresent(System.out::println);
                }
                data.notifyAll();
            }
        }, name);

    }

}
