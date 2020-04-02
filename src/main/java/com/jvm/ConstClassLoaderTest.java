package com.jvm;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/1/28
 * @since JDK 1.8
 */
public class ConstClassLoaderTest {

/*
1，常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中： ConstClassLoaderTest的常量池
2，本质上，调用类并没有直接引用到定义常量的类，所以不会触发定义常量的类的初始化
3，这里将常量str的内容放入到 ConstClassLoaderTest的常量池中
4，阔以删除MyParent的class文件不会出现问题

反编译进行查看 javap -c ./com/jvm/ConstClassLoaderTest

助记符：
    ldc: 表示将int ，float 与 String 类型的常量推入到栈顶
    bipush：表示将单字节（-128~+127）的常量推入到栈顶
    sipush: 表示把短整型（-32768~+32767）2^（16-1） 二的十五次方 两个字节大小推送到栈顶
    iconst_5: 表是把int整型（1~5)之间的数据推送到栈顶

public static void main(java.lang.String[]);
    Code:
       0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: sipush        32767
       6: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
       9: return
}
* */
    public static void main(String[] args) {
        //这里是不会进行MyParent初始化
        System.out.println(MyParent.f);
    }

}

class MyParent{

    public static final String str = "hello world";

    public static final short i = 7;

    public static final int l = 5;

    public static final int k = 32767;

    public static final int f = 1234567;

    static {
        System.out.println("MyParent static block");
    }
}