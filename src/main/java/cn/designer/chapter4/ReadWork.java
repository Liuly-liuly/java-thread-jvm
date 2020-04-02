package cn.designer.chapter4;

import jdk.jfr.events.ExceptionThrownEvent;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/20
 * @since JDK 1.8
 */
public class ReadWork extends Thread {

    private final ShareData shareData;

    public ReadWork(ShareData shareData){
        this.shareData = shareData;
    }

    @Override
    public void run() {
        try{
            while(true){
                char[] read = shareData.read();
                System.out.println(Thread.currentThread().getName()+" read "+ String.valueOf(read));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
