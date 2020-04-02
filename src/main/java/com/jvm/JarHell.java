package com.jvm;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/1/31
 * @since JDK 1.8
 */
public class JarHell {

    public static void main(String[] args) throws Exception{

        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        String resourceName = "java"+ File.separator+"lang"+File.separator+"String";
        Enumeration<URL> ite = systemClassLoader.getResources(resourceName);
        while (ite.hasMoreElements()){
            System.out.println(ite.nextElement());
        }
    }
}