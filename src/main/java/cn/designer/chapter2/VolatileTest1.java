package cn.designer.chapter2;

import java.security.acl.LastOwnerException;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/15
 * @since JDK 1.8
 */
public class VolatileTest1 {

    private static volatile int INDEX = 0;
    //加volatile 的区别
    //private static  int INDEX = 0;

    private static int MAX = 50;

    public static void main(String[]args){

        new Thread(()->{
            int localValue = INDEX;
            while (localValue<MAX){ //当updater线程把index 跟新后会刷到内存中
                //这里会从内存中读取数据，会发现改变，volatile的作用
                if(localValue != INDEX){
                    System.out.printf("The value update to [%d]\n",INDEX);
                    localValue = INDEX;
                }
            }
        },"READER").start();

        new Thread(()->{
            int localValue = INDEX;
            while (localValue < MAX){
                System.out.printf("update the value [%d]\n",++localValue);
                INDEX = localValue;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"UPDATER").start();
    }
}
