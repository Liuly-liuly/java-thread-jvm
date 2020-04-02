package com.gc;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/2/9
 * @since JDK 1.8
 */
public class JVMGCtest {

//    java -XX:+PrintCommandLineFlags -version 打印出虚拟机启动时默认的参数
//    C:\Users\hand> java -XX:+PrintCommandLineFlags -version
//    -XX:InitialHeapSize=266672640 -XX:MaxHeapSize=4266762240 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
//    java version "1.8.0_131"
//    Java(TM) SE Runtime Environment (build 1.8.0_131-b11)
//    Java HotSpot(TM) 64-Bit Server VM (build 25.131-b11, mixed mode)
//    PS C:\Users\hand>


    /*
    -verbose:gc  打出GC过程时的日志
    -Xms20m   堆初始化大小
    -Xmx20m   堆总的大小
    -Xmn10m   新生代的带下
    -XX:+PrintGCDetails  打印出堆GC过后的详细信息
    -XX:SurvivorRatio=8  Eden区与survivor的占比 8:1:1
    * */

    public static void main(String[] args) {
        int size = 1024 * 1024;

//        [GC (Allocation Failure) [PSYoungGen: 6454K->808K(9216K)] 6454K->4912K(19456K), 0.0041620 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//        hello world
//        Heap
//        PSYoungGen      total 9216K, used 4117K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
//        eden space 8192K, 40% used [0x00000000ff600000,0x00000000ff93b6f0,0x00000000ffe00000)
//        from space 1024K, 78% used [0x00000000ffe00000,0x00000000ffeca020,0x00000000fff00000)
//        to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
//        ParOldGen       total 10240K, used 9224K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
//        object space 10240K, 90% used [0x00000000fec00000,0x00000000ff502030,0x00000000ff600000)
//        Metaspace       used 3495K, capacity 4498K, committed 4864K, reserved 1056768K
//        class space    used 387K, capacity 390K, committed 512K, reserved 1048576K

        //4912K - 808K = 4104k
        //5*1024k +4104k=9224k
        //这里表明了如果对象内存太大直接在老年代开辟

        byte[] bytes_1 = new byte[2*size];
        byte[] bytes_2 = new byte[2*size];
        byte[] bytes_3 = new byte[3*size];
        byte[] bytes_4 = new byte[5*size];
       // byte[] bytes_5 = new byte[3*size];
        System.out.println("hello world");
    }
}
