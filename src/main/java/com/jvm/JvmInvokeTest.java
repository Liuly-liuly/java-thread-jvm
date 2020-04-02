package com.jvm;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/2/3
 * @since JDK 1.8
 */
public class JvmInvokeTest {
    /*
    invokeInterface: 调用接口的方法，根据运行时期确定调用那一个实现类的方法
    invokeStatic: 调用静态方法
    invokeSpecial: 调用私有方法，<init>构造方法，父类方法
    invokeVirtual: 调用虚方法，运行期间动态查找
    invokeDynamic: 动态调用方法
    * */

    /*
    静态解析的4中情形
    1 静态方法
    2 父类方法
    3 构造方法
    4 私有方法
    以上4类属于非虚方法，在类加载解析时就可以由符号引用转换为直接引用
    * */

    public static void print(){
        System.out.println("------");
    }

    /*
    变量的静态类型是不会发生变化的，而变量的实际类型则是可以发生变化（多态），事件类型则是在运行期运行
    方法的静态分派，指的是方法参数是静态的，而指向的实例是不确定的、
    字节码调用：invokeVirtual
    * */

    public static void main(String[] args) {
        JvmInvokeTest.print();
        // 方法重载，是一种静态的行为
        Animal dog = new Dog();
        Animal pig = new Pig();

        JvmInvokeTest jvmInvokeTest = new JvmInvokeTest();
        jvmInvokeTest.test(dog);
        jvmInvokeTest.test(pig);
    }

    //方法重载，同名参数不同（类型，个数）
    public void test(Animal animal){
        System.out.println("animal");
    }

    public void test(Dog animal){
        System.out.println("dog");
    }

    public void test(Pig animal){
        System.out.println("pig");
    }

}


class Animal{

}

class Dog extends Animal{

}

class Pig extends  Animal{

}