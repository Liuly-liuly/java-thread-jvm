package com.memory;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/2/7
 * @since JDK 1.8
 */
public class MetaSpaceTest {

    // -Xss160k 指定虚拟机栈的大小 stack size
    //指定元空间大小
    //-XX:MaxMetaSpaceSize=200m -XX:+TracingClassLoading
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MetaSpaceTest.class);
        enhancer.setUseCache(false);
        enhancer.setCallback((MethodInterceptor)(obj, method, args1, proxy)->proxy.invokeSuper(obj,args1));
        System.out.println("-------------");
        enhancer.create();
    }

}
