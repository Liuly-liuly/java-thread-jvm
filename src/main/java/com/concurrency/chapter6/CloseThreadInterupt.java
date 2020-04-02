package com.concurrency.chapter6;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/6
 * @since JDK 1.8
 */
public class CloseThreadInterupt {

    public static class Work extends Thread {

        @Override
        public void run() {
            while (true){
                if(this.isInterrupted()) break;
                System.out.println("---->loading data");
            }
        }

        public void shutdown() {
            this.interrupt();
        }
    }
    public static void main(String[] args) {
       Work work = new Work();
       work.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        work.shutdown();
    }

}
