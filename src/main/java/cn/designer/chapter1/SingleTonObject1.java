package cn.designer.chapter1;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/15
 * @since JDK 1.8
 */
public class SingleTonObject1 {

    private static volatile SingleTonObject1 singleTonObject1;

    private SingleTonObject1(){}

    //lazy load and double check and add volatile
    public static SingleTonObject1 getInstance(){

        if(null == singleTonObject1){
            synchronized (SingleTonObject1.class){
                if(null == singleTonObject1 )
                    singleTonObject1 = new SingleTonObject1();
            }
        }

        return singleTonObject1;
    }
}
