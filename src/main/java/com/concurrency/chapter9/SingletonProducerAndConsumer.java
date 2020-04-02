package com.concurrency.chapter9;

import java.util.stream.Stream;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/11
 * @since JDK 1.8
 */
public class SingletonProducerAndConsumer {

    private int i = 1;

    private Boolean flag = false;

    private Object monitor = new Object();

    public void produce (){
        synchronized (monitor){
            if(flag){
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                i++;
                flag = true;
                monitor.notify();
            }
        }
    }


    public void consume(){

        synchronized (monitor){
            if(flag){
                System.out.println("c-->"+i);
                flag = false;
                monitor.notify();
            }else {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String [] args){


        SingletonProducerAndConsumer singletonProducerAndConsumer = new SingletonProducerAndConsumer();

        //这里出现多个生产者消费者，容易导致消费者通知消费者出现所有的线程进去waitting状态
        Stream.of("P1","P2").forEach(i->{
            new Thread(i){
                @Override
                public void run() {
                    while (true)
                        singletonProducerAndConsumer.produce();
                }
            }.start();
        });


        Stream.of("C1","C2").forEach(i->{
            new Thread(i){
                @Override
                public void run() {
                    while (true)
                        singletonProducerAndConsumer.consume();
                }
            }.start();
        });

    }

}
