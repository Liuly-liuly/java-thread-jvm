package com.concurrency.chapter2;


public class TicketWindowRunable implements Runnable {

        private int index = 1;

        private final  int MAX = 1500;

        public void run() {

            while (index <= MAX) {
                System.out.println("---->name:"+Thread.currentThread().getName()+"第几号："+index++);
            }
        }

}
