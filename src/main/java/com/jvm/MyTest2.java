package com.jvm;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/1/30
 * @since JDK 1.8
 */
public class MyTest2 {

    public static void main(String[] args) throws Exception{

        CustomClassloader loader1 = new CustomClassloader("loader1");

        loader1.setPrefix("C:\\Users\\hand\\Desktop\\");
        Class<?> aClass = loader1.loadClass("com.jvm.Mytest1");

        System.out.println(aClass.getClassLoader());
    }
}
