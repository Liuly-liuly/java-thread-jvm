package com.concurrency.chapter5;

public class ThreadJoin3 {

    public static void main(String[] args) throws InterruptedException {
        long startTimestamp = System.currentTimeMillis();
        Thread t1 = new Thread(new CaptureRunnable("M1", 10000L));
        Thread t2 = new Thread(new CaptureRunnable("M2", 30000L));
        Thread t3 = new Thread(new CaptureRunnable("M3", 15000L));

        t1.start();
        t2.start();
        t3.start();

        //等完最长的那个线程执行完在执行，会比执行时间最长的线程多几十毫秒罢了
        t1.join();
        t2.join();
        t3.join();

        long endTimestamp = System.currentTimeMillis();
        System.out.printf("Save data  timestamp is:%s\n", endTimestamp-startTimestamp);
    }

}

class CaptureRunnable implements Runnable {

    private String machineName;

    private long spendTime;

    public CaptureRunnable(String machineName, long spendTime) {
        this.machineName = machineName;
        this.spendTime = spendTime;
    }

    @Override
    public void run() {
        //do the really capture data.
        try {
            Thread.sleep(spendTime);
            System.out.printf(machineName + " completed data capture at timestamp [%s] and successfully.\n", System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getResult() {
        return machineName + " finish.";
    }
}