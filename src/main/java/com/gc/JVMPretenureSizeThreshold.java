package com.gc;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/2/9
 * @since JDK 1.8
 */
public class JVMPretenureSizeThreshold {


    /*
-verbose:gc
-Xms20m
-Xmx20m
-Xmn10m
-XX:+PrintCommandLineFlags 输出jvm启动时的参数
-XX:+PrintGCDetails
-XX:SurvivorRatio=8
-XX:PretenureSizeThreshold=4194304 设置对象超过多大的时候，直接到老年代创建
-XX:+UseSerialGC  必须要使用serial 才能使上面那个参数有效
    * */

    public static void main(String[] args) {
        int size = 1024 * 1024;
//        [Full GC (Allocation Failure) Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//        at com.gc.JVMPretenureSizeThreshold.main(JVMPretenureSizeThreshold.java:27)
//        [PSYoungGen: 0K->0K(9216K)] [ParOldGen: 688K->670K(10240K)] 688K->670K(19456K), [Metaspace: 3487K->3487K(1056768K)], 0.0101000 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
//        Heap
        byte[] bytes_4 = new byte[10*size];
        // byte[] bytes_5 = new byte[3*size];
        System.out.println("hello world");
    }
}
