package com.jvm;

import java.awt.*;
import java.util.UUID;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/1/28
 * @since JDK 1.8
 */
public class ConstLoaderTest {
    /*
    public static void main(java.lang.String[]);
    Code:
            0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
            3: getstatic     #3                  // Field com/jvm/Parent.str:Ljava/lang/String;
            6: invokevirtual #4                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
            9: return
}
表示在非编译期间确定常量的值，所以会主动调用常量的类进行初始化

助记符：
   anewarrary: 表示初始化一个引用类型的数组
   newarray: 表示初始化一个基本类型的数组 （byte short int float boolean char float double long)
*/
    public static void main(String[] args) {
        System.out.println(Parent.str);
        Parent[] da = new Parent[5]; //数组是动态生成的一种类型，它实际的类型其实是Component对应的原生类型Parent
        for (Parent i:
             da) {
            System.out.println(i);// print null
        }
    }
}


class Parent{
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent static block");
    }
}
