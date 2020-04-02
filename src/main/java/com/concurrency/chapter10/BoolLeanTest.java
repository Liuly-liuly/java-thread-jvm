package com.concurrency.chapter10;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/11
 * @since JDK 1.8
 */
public class BoolLeanTest {

   public static void main(String[] args){

       BooleanClock booleanClock = new BooleanClock();

       Stream.of("M1","M2","M3","M4","M5")
              .forEach(name->{
                  new Thread(()->{

                      try {

                          booleanClock.lock();

                          Optional.of(Thread.currentThread().getName() + " have the lock Monitor")
                                  .ifPresent(System.out::println);

                          work();

                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }finally {
                          booleanClock.unlock();
                      }

                  },name).start();

              });
   }

    private static void work() throws InterruptedException {
        Optional.of(Thread.currentThread().getName() + " is Working...")
                .ifPresent(System.out::println);
        Thread.sleep(4_000);
    }

}
