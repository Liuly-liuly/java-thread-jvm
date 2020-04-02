package com.jvm;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/1/28
 * @since JDK 1.8
 */
public class MyTest{

    public static void main(String[] args) {
        SingelTon singelTon = SingelTon.getSingelTon();
        System.out.println(SingelTon.counter1);
        System.out.println(SingelTon.counter2);
        for (;;){
            System.out.println("hello");
        }
    }
}


class SingelTon {

    public static  int counter1 ;


    private static SingelTon singelTon = new SingelTon();

    public SingelTon() {
        counter1++;
        counter2++;
        System.out.println("--->"+counter1);
        System.out.println("--->"+counter2);
    }

    public static int counter2 =0 ;

    public static SingelTon getSingelTon(){
        return singelTon;
    }

}
