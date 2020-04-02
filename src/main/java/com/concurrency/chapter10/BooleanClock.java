package com.concurrency.chapter10;

import com.sun.javafx.UnmodifiableArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/11
 * @since JDK 1.8
 */
public class BooleanClock implements Lock {

    private Boolean aBooleanLock = false;

    private Collection<Thread> waitThread = new ArrayList<>();

    private Thread currentThread ;

    @Override
    public synchronized void lock() throws InterruptedException {
        waitThread.add(Thread.currentThread());
        while (aBooleanLock){
            this.wait();
        }
        waitThread.remove(Thread.currentThread());
        aBooleanLock = true;
        currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {

        if(mills<=0)
            lock();

        long remainingTime = mills;
        long endTime = System.currentTimeMillis()+mills;

        while (aBooleanLock){
            if(remainingTime<=0) {
                waitThread.remove(Thread.currentThread());
                throw new TimeOutException("time out....");
            }
            waitThread.add(Thread.currentThread());
            this.wait(mills);
            remainingTime = endTime - System.currentTimeMillis();
        }
        waitThread.remove(Thread.currentThread());
        aBooleanLock = true;
        currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void unlock() {
        if(currentThread == Thread.currentThread()){
            aBooleanLock =false;
            Optional.of("release the lock").ifPresent(System.out::println);
            this.notifyAll();
            //notify 一个一个通知，谁先进队列谁先出 ，可以在lock的时候用 if
            // if (aBooleanLock){
            //            waitThread.add(Thread.currentThread());
            //            this.wait();
            //        }
            // 默认代表了 aBooleanLock 为false 可以放行一个waiting 的线程
            //*弊病 ，不能配合lock(mills) 去使用，失效并且无锁
            //this.notify();
        }
    }

    @Override
    public Collection<Thread> getBlockedThread() {
        return Collections.unmodifiableCollection(waitThread);
    }

    @Override
    public int getBlockThreadSize() {
        return waitThread.size();
    }
}
