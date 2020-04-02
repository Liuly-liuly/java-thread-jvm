package com.concurrency.chapter2;

import com.concurrency.chapter1.TicketWindow;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/10/18
 * @since JDK 1.8
 */
public class Bank {

    private static final int MAX = 150;

    public static void main(String[] args){


        final Runnable ticketWindow = ()-> {
                int index = 1;
                while (index <= MAX) {
                    System.out.println(Thread.currentThread() + " 的号码是:" + (index++));

                }
        };

        Thread windowThread1 = new Thread(ticketWindow, "一号窗口");
        Thread windowThread2 = new Thread(ticketWindow, "二号窗口");
        Thread windowThread3 = new Thread(ticketWindow, "三号窗口");
        windowThread1.start();
        windowThread2.start();
        windowThread3.start();

    }
}
