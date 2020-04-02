package com.gc;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/2/9
 * @since JDK 1.8
 */

/*
-verbose:gc
-Xmx200m
-Xmn50m
-XX:+PrintCommandLineFlags
-XX:+PrintGCDetails
-XX:TargetSurvivorRatio=60  表示当survivor空间占用60%时，会自动重新计算下面的阈值进行晋升
-XX:MaxTenuringThreshold=3
-XX:+PrintTenuringDistribution
-XX:+PrintGCDateStamps
-XX:+UseConcMarkSweepGC   CMS 收集器一般配合 ParNew使用   +UserSerialGC   +UserParallelGC
-XX:+UseParNewGC
* */
//一般都是在新创建对象的时候，会计算新生代空间是否够，
public class MaxTenuringThresholdDetail {

    public static void main(String[] args) throws InterruptedException {

        byte[] bytes_1 = new byte[512*1024];
        byte[] bytes_2 = new byte[512*1024];

        GC();
        Thread.sleep(1000);
        System.out.println("11111111");

        GC();
        Thread.sleep(1000);
        System.out.println("22222222");

        GC();
        Thread.sleep(1000);
        System.out.println("33333333");


        GC();
        Thread.sleep(1000);
        System.out.println("44444444");


        byte[] bytes_3 = new byte[1024*1024];
        byte[] bytes_4 = new byte[1024*1024];
        byte[] bytes_5 = new byte[1024*1024];
        byte[] bytes_6 = new byte[1024*1024];

        GC();
        Thread.sleep(1000);
        System.out.println("55555555");

        GC();
        Thread.sleep(1000);
        System.out.println("66666666");
    }

    public static void GC(){

        for(int i =0 ; i< 40; i++){
            byte[] bytes = new byte[1024*1024];
        }

    }
}
