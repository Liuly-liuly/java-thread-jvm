package cn.designer.chapter1;

import java.util.stream.IntStream;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/15
 * @since JDK 1.8
 */
public class SingleTonObject3 {

    private SingleTonObject3(){}

    //枚举只有在获取实例是会初始化一次，其余都不会初始化
    private enum SingleTon{
        INSTANCE;

        private final SingleTonObject3 instance ;

        SingleTon(){
            //System.out.println("--->");
            instance = new SingleTonObject3();
        }

        public SingleTonObject3 getInstance(){
            return instance;
        }
    }

    public static SingleTonObject3 getInstance(){
       return SingleTon.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100)
                .forEach(i -> new Thread(String.valueOf(i)) {
                    @Override
                    public void run() {
                        System.out.println(SingleTonObject3.getInstance());
                    }
                }.start());
    }
}
