package cn.designer.chapter2;

import javax.jws.soap.SOAPBinding;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/15
 * @since JDK 1.8
 */
public class VolatileTest2 {

    private static volatile int INDEX = 0;
    
    private static int MAX = 50;
    
    public static void main(String[]args){
        new Thread(()->{
            while (INDEX<MAX){
                int localValue = INDEX;
                ++localValue;
                INDEX = localValue;
                System.out.printf("update value [%d]\n",localValue);

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"add-01").start();

        new Thread(()->{
            while (INDEX<MAX){
                int localValue = INDEX;
                ++localValue;
                INDEX = localValue;
                System.out.println("T2->" + localValue);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"upper").start();
    }

}
