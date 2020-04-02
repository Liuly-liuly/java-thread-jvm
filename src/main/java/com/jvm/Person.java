package com.jvm;

import java.security.PublicKey;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/1/30
 * @since JDK 1.8
 */
public class Person {

    private Person person;

    public void setPerson(Object ob){
        System.out.println("class name "+ob.getClass().getName());
        Person person = new Person();
        System.out.println("----"+person.getClass().getClassLoader());
        this.person = (Person) ob;
    }
}
