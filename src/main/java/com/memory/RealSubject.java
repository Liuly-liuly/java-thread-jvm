package com.memory;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/2/7
 * @since JDK 1.8
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("real subject request method");
    }
}
