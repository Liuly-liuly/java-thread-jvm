package com.concurrency.chapter13;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/2/3
 * @since JDK 1.8
 */
public class Animal {

    public static final String  str = "change job";

    private Animal(){}

    public Animal(String s){}

    public void print(){
        System.out.println(str);
    }

    public void sl(){
        System.out.println("sleeping");
    }

    public void run (){
        System.out.println("running");
    }

    public void eat(){

        System.out.println("eating");
    }

}
