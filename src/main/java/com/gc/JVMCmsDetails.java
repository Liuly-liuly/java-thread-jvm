package com.gc;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/2/9
 * @since JDK 1.8
 */
public class JVMCmsDetails {

    public static void main(String[] args) {
        int size = 1024 * 1024;
        byte[] bytes_1 = new byte[4*size];

        System.out.println("111111111");
        byte[] bytes_2 = new byte[4*size];

        System.out.println("222222222");

        byte[] bytes_3 = new byte[4*size];

        System.out.println("333333333");
        byte[] bytes_4 = new byte[2*size];

        System.out.println("444444444");
        byte[] bytes_5 = new byte[1*size];

        System.out.println("555555555");
    }
}
