package com.concurrency.chapter1;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/10/18
 * @since JDK 1.8
 */
public class TicketWindow extends Thread {

    private final String name;

    private static int MAX = 50;

    private static int index = 0;


    public TicketWindow(String name){
        this.name = name;
    }

    @Override
    public void run() {
       while (index <= MAX){
           System.out.println("---->name:"+name+"第几号："+index++);
       }
    }
}
