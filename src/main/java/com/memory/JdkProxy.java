package com.memory;

import sun.misc.ProxyGenerator;

import java.lang.reflect.Proxy;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/2/7
 * @since JDK 1.8
 */
public class JdkProxy {

    public static void main(String[] args) {
        // ProxyGenerator.saveGeneratedFiles
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Subject realSubject = new RealSubject();
        DynamicSubject dynamicSubject = new DynamicSubject(realSubject);
        //基于接口的方式进行代理
        Class<?> aClass = realSubject.getClass();
        Subject o =(Subject) Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), dynamicSubject);
        o.request();

        System.out.println(o.getClass());
        System.out.println(o.getClass().getSuperclass());
        System.out.println(o.getClass().getInterfaces());
    }
}
