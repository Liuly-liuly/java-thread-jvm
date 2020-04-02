package com.concurrency.chapter6;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/6
 * @since JDK 1.8
 */
public class ThreadService {

    private Thread executeThread;

    private Boolean finish = false;

    public void createThread(Runnable runnable){

        executeThread = new Thread(){
            @Override
            public void run() {
                Thread inner = new Thread(runnable);
                inner.setDaemon(true);
                inner.start();
                try {
                    inner.join();
                    finish = true;
                } catch (InterruptedException e) {
                    finish = true;
                    e.printStackTrace();
                }
            }
        };

       executeThread.start();
    }

    public boolean shutDown(long mills){

        long current = System.currentTimeMillis();

        while (!finish){
            if(System.currentTimeMillis() - current >= mills){
                System.out.println("--->stop the thread work");
                executeThread.interrupt();
            }else {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        return true;
    }
}
