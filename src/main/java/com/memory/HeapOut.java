package com.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/2/7
 * @since JDK 1.8
 */
public class HeapOut {

    public static void main(String[] args) {
        List list = new ArrayList();

        for(;;){
            list.add(HeapOut.class);
        }
    }
}
