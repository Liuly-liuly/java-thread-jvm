package com.jvm;

import sun.awt.windows.ThemeReader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/1/30
 * @since JDK 1.8
 */
public class JdbcTest {

    public static void main(String[] args) {

        //SPI service provider interface
        //Thread.currentThread().setContextClassLoader(ClassLoader.getSystemClassLoader().getParent());
        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterator = loader.iterator();

        while (iterator.hasNext()){
            Driver next = iterator.next();
            System.out.println(next.toString()+"--->"+next.getClass().getClassLoader());
        }
        System.out.println("serviceLoader: "+ServiceLoader.class.getClassLoader());
        System.out.println("current thread classloader " +Thread.currentThread().getContextClassLoader());
    }
}
