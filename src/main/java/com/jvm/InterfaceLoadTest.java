package com.jvm;

import java.util.Random;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/1/28
 * @since JDK 1.8
 */
public class InterfaceLoadTest {

    /*
    *  当初始化一个接口时，它所继承的接口并不会被初始化
    *  当一个类被初始化时，并不会初始化它所实现的接口
    *  当接口定义并实现了default 类型的方法时，父接口是会被初始化
    *  倘若父接口还集成了其它接口，其它接口实现了默认方法，而父接口没有
    *  则会初始化其它的接口不初始化父接口 ----相当奇葩，不过类实现大于接口实现
    * */

    public static void main(String[] args) {
        System.out.println(Child.kk);
        MyChild child = new Child();
        //字节码生成是根据父类的println ；
        // 但是父类并没有该方法因此产生的静态字节码无法找到MyChild.println这个方法，
        // 所以会报错，编译期间都无法通过；
        //child.println();
    }
}
interface MyParent5{

    int a = 5;

    String str = "hello" ;

    Thread thread = new Thread(){
        {
            System.out.println("MyParent5 Thread block");
        }
    };

    default void print(){
        System.out.println(a);
        System.out.println(str);
    }
}
interface MyChild extends MyParent5{
    int b = 6;
    public static final String bkr = "welcome";
    Thread thread = new Thread(){
        {
            System.out.println("MyChild Thread block");
        }
    };

    @Override
    default void print(){
        System.out.println(b);
        System.out.println(bkr);
    }

}

class Child implements MyChild{
    public static int kk = 1234;
    static {
        System.out.println("---->");
    }
    public void println(){
        System.out.println(kk);
    }
}