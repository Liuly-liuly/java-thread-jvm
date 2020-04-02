package com.jvm;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/1/29
 * @since JDK 1.8
 */
public class Mytest1 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> aClass = systemClassLoader.loadClass("com.jvm.Cl");
        System.out.println(aClass);
        System.out.println("---------");
        Class<?> aClass1 = Class.forName("com.jvm.Cl");
        System.out.println(aClass1);
        System.out.println(aClass1.getFields());
    }

}

class Cl{

    static {
        System.out.println("CL static block");
    }
}
