package com.concurrency.chapter6;

import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/6
 * @since JDK 1.8
 */
public class CloseThreadForce {

    public static void main(String[]args){
        ThreadService threadService = new ThreadService();
        threadService.createThread(()->{
            System.out.println("=======loading data=======");
            while (true){
                //System.out.println("======》loading ");
            }
        });

        threadService.shutDown(100000);

        System.out.println("======》thread closed !!!!! ");
    }



}
