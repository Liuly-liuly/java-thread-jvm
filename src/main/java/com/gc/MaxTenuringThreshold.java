package com.gc;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/2/9
 * @since JDK 1.8
 */
public class MaxTenuringThreshold {

    /*
    MaxTenuringThreshold作用：可以自动调节对象晋升到老年代的阈值；当对象被gc一次age++
    默认参数为15，CMS 中默认为6 ，G1默认为15（jvm 四位表示 1111 --> F)
    当survivor中的空间超过50% 会使得对象快速晋升，会自动减少该阈值
    * */


//    [GC (Allocation Failure)
//    Desired survivor size 1048576 bytes, new threshold 5 (max 5)
//            [PSYoungGen: 6454K->776K(9216K)] 6454K->4872K(19456K), 0.0045978 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//            [GC (Allocation Failure) --[PSYoungGen: 7075K->7075K(9216K)] 11171K->14243K(19456K), 0.0037609 secs] [Times: user=0.02 sys=0.02, real=0.00 secs]
//            [Full GC (Ergonomics) [PSYoungGen: 7075K->3753K(9216K)] [ParOldGen: 7168K->7168K(10240K)] 14243K->10921K(19456K), [Metaspace: 3487K->3487K(1056768K)], 0.0085004 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
//    hello world
//    Heap
//    PSYoungGen      total 9216K, used 7200K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
//    eden space 8192K, 87% used [0x00000000ff600000,0x00000000ffd083e8,0x00000000ffe00000)
//    from space 1024K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x00000000fff00000)
//    to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
//    ParOldGen       total 10240K, used 7168K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
//    object space 10240K, 70% used [0x00000000fec00000,0x00000000ff300030,0x00000000ff600000)
//    Metaspace       used 3495K, capacity 4498K, committed 4864K, reserved 1056768K
//    class space    used 387K, capacity 390K, committed 512K, reserved 1048576K

    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] bytes_1 = new byte[2*size];
        byte[] bytes_2 = new byte[2*size];
        byte[] bytes_3 = new byte[3*size];
        byte[] bytes_4 = new byte[3*size];
        byte[] bytes_5 = new byte[3*size];
        System.out.println("hello world");
    }
}
