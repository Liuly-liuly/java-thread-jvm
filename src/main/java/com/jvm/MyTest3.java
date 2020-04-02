package com.jvm;

import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/1/30
 * @since JDK 1.8
 */
public class MyTest3 {

    public static void main(String[] args)throws Exception {
        CustomClassloader loader1 = new CustomClassloader("loader1");
        CustomClassloader loader2 = new CustomClassloader("loader2");

        loader1.setPrefix("C:\\Users\\hand\\Desktop\\");
        loader2.setPrefix("C:\\Users\\hand\\Desktop\\");
        Class<?> aClass = loader1.loadClass("com.jvm.Person");
        Class<?> aClass1 = loader2.loadClass("com.jvm.Person");

        System.out.println(aClass.getClassLoader());
        System.out.println(aClass1.getClassLoader());
        System.out.println("-----------");

        Object o = aClass.newInstance();
        Object o1 = aClass1.newInstance();

        System.out.println(o.getClass().getName()+"------------"+o1.getClass().getName());

        Method setPerson = aClass.getMethod("setPerson" ,Object.class);
        Object invoke = setPerson.invoke(o, o1);
        System.out.println(invoke);
    }
}
