package com.concurrency.chapter1;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/10/18
 * @since JDK 1.8
 */
public class Bank {

    public static void main(String[] args){

        TicketWindow ticketWindow1 = new TicketWindow("一号柜台");
        ticketWindow1.start();

        TicketWindow ticketWindow2 = new TicketWindow("二号柜台");
        ticketWindow2.start();

        TicketWindow ticketWindow3 = new TicketWindow("三号柜台");
        ticketWindow3.start();

    }
}
