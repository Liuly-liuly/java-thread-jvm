package com.concurrency.chapter10;

import java.util.Collection;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/11
 * @since JDK 1.8
 */
public interface Lock{

class TimeOutException extends Exception{
    public TimeOutException(String message) {
        super(message);
    }
}

void lock() throws InterruptedException;

void lock(long mills)throws InterruptedException,TimeOutException;

void unlock();

Collection<Thread> getBlockedThread();

int getBlockThreadSize();

}
