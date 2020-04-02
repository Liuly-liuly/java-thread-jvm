package cn.designer.chapter1;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/15
 * @since JDK 1.8
 */
public class SingleTonObject2 {

    static {
        System.out.println("--->");
        i= 1;
    }

    public static int i = 0;

    static {
        System.out.println(i);
    }


    private SingleTonObject2(){}

    //把它当做静态类以及类似于静态属性
    //静态变量只会初始化一次 only 所以保证该单例模式不会出现重复创建以及重复赋值
    private static class SingleTon{
        private final static SingleTonObject2 instance = new SingleTonObject2();

        private Long l ;

        public Integer i;
    }

    public static SingleTonObject2 getInstance(){
        SingleTon singleTon = new SingleTon();
        Long i = singleTon.l;
        return SingleTon.instance;
    }


}
