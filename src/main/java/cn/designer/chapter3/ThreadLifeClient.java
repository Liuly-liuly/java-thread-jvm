package cn.designer.chapter3;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/18
 * @since JDK 1.8
 */
public class ThreadLifeClient {

    public static void main(String[]args){
        new ThreadLifeCycleListener().query(Arrays.asList("1", "2"));
    }

}
