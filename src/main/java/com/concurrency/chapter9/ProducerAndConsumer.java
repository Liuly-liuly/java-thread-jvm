package com.concurrency.chapter9;

import java.util.stream.Stream;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/11
 * @since JDK 1.8
 */
public class ProducerAndConsumer {

    private int i = 1;

    private Boolean flag = false;

    private Object monitor = new Object();

    public void produce (){

        synchronized (monitor) {
            while (flag){
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            i++;
            flag = true;
            monitor.notifyAll();
        }
    }


    public void consume(){

        synchronized (monitor){

            while (!flag){
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("c--->"+i);
            flag = false;
            monitor.notifyAll();
        }

    }


    public static void main(String [] args){
        ProducerAndConsumer producerAndConsumer = new ProducerAndConsumer();

        Stream.of("P1","P2").forEach(i->{
            new Thread(i){
                @Override
                public void run() {
                    while (true)
                        producerAndConsumer.produce();
                }
            }.start();
        });


        Stream.of("C1","C2").forEach(i->{
            new Thread(i){
                @Override
                public void run() {
                    while (true)
                        producerAndConsumer.consume();
                }
            }.start();
        });

    }

}
