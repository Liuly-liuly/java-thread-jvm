package com.jvm;

import java.sql.DriverManager;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/1/31
 * @since JDK 1.8
 */
public class MyTest4 {
    public static void main(String[] args)throws Exception {
        Object o = new Object();
        System.out.println(o.getClass());
        System.out.println(o.getClass().getClassLoader());
        Class.forName("com.mysql.jdbc.Driver");
        DriverManager.getConnection("jdbc:mysql://localhost:3306/hap","root" ,"root");
    }
}
