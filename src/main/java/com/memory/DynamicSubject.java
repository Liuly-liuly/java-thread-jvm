package com.memory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/2/7
 * @since JDK 1.8
 */
public class DynamicSubject implements  InvocationHandler{

    private Subject subject;

    public DynamicSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---before---"+method);
        method.invoke(subject,args);
        System.out.println("---after-----"+method);
        return null;
    }
}
