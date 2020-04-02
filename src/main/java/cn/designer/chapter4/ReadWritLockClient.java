package cn.designer.chapter4;


public class ReadWritLockClient {
    public static void main(String[] args) {
        final ShareData sharedData = new ShareData(10);
        new ReadWork(sharedData).start();
        new ReadWork(sharedData).start();
        new ReadWork(sharedData).start();
        new ReadWork(sharedData).start();
        new ReadWork(sharedData).start();
        new WriteWork(sharedData, "qwerer").start();
        new WriteWork(sharedData, "ABCDEFG").start();
    }
}