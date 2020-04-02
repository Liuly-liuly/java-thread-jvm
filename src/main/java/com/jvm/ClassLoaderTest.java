package com.jvm;

import java.util.Arrays;

/**
 * 对于静态字段来讲，只有定义了该字段的类才会被初始化
 * 一个类初始化时，要求其父类全部初始化完成
 *  -XX:+TraceClassLoading 追踪类的加载信息并打印出来
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        System.out.println(child.str);
        //child child = new child();
        //child.print();
        //Class<?> aClass = Class.forName("com.jvm.child");
    }
}

class parent {
    static {
        str = "xxxxxx";
    }
    public static  String str = "hello world";

    private String testStr;
    static {
        System.out.println("parent static block");
        str = "llllll";
    }


    public parent() {
        System.out.println("==========");
    }

    public parent(String s) {
        testStr = s;
    }

    public void print(){
        System.out.println(testStr);
    }
}

class child extends parent{
    public static String str1 = "welcome";

    public child() {
        //会调用父类的无参构造方法
    }

    public child(String ss) {
        //前提是父类申明了有参的构造方法
        //如果父类没有无参的构造方法，则这里需要显示调用父类构造方法初始化
        //父类有无参的构造方法，则阔以不用显示调用，也会自动调用无参构造方法进行初始化
        super(ss);
        System.out.println("constructor");
    }

    static {
        System.out.println("child static block");
    }
}
