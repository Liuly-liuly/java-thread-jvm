package com.concurrency.chapter9;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/11
 * @since JDK 1.8
 */
public class SimpleProducerAndConsumer {

    private int i = 1;

    private String s = "产品";

    private Object monitor = new Object();

    private void producer(){
       synchronized (monitor){
           System.out.println("produce "+s+(i++));
       }
    }

    private void consumer(){
        synchronized (monitor){
            System.out.println("consume "+s+i);
        }
    }

    public static void main(String [] args){
        SimpleProducerAndConsumer simpleProducerAndConsumer = new SimpleProducerAndConsumer();

        new Thread("p"){
            @Override
            public void run() {
                while (true)
                  simpleProducerAndConsumer.producer();
            }
        }.start();

        new Thread("c"){
            @Override
            public void run() {
                while (true)
                  simpleProducerAndConsumer.consumer();
            }
        }.start();

    }

}
