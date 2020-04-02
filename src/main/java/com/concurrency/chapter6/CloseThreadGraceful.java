package com.concurrency.chapter6;


/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/6
 * @since JDK 1.8
 */
public class CloseThreadGraceful {

    public static class Work extends Thread {

        private volatile Boolean start = true;

        @Override
        public void run() {
            while (start){
                System.out.println("======》loading ");
            }
        }

        public void shutdown() {
            this.start = false;
        }
    }
    public static void main(String[] args) {
        Work worker = new Work();
        worker.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.shutdown();
    }
}
