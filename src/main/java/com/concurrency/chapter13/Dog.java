package com.concurrency.chapter13;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/2/3
 * @since JDK 1.8
 */
public class Dog extends Animal{

    public static final String  ss = "new job";

    public Dog() {
        super(ss);
    }

    @Override
    public void print() {
        System.out.println(ss);
    }

    @Override
    public void sl() {
        System.out.println("dog sleeping");
    }

    @Override
    public void run() {
        System.out.println("dog running");
    }

    @Override
    public void eat() {
        System.out.println("dog eating");
    }
}
