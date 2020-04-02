package cn.designer.chapter;

import cn.designer.chapter1.SingleTonObject3;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.stream.IntStream;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/15
 * @since JDK 1.8
 */
public class SingleTonFinal {

    private SingleTonFinal(){}

    private enum SingleTon{
        INSTANCE;

        private final SingleTonFinal instance;

        SingleTon(){
            instance = new SingleTonFinal();
        }

        public SingleTonFinal getInstance() {
            return instance;
        }
    }

    public static SingleTonFinal getInstance(){
        return SingleTon.INSTANCE.getInstance();
    }

    public static void main(String[] args) {

        IntStream.rangeClosed(1, 100)
                .forEach(i -> new Thread(String.valueOf(i)) {
                    @Override
                    public void run() {
                        System.out.println(SingleTonFinal.getInstance());
                    }
                }.start());
    }

}
