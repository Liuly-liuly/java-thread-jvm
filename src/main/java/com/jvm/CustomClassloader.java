package com.jvm;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2020/1/29
 * @since JDK 1.8
 */
public class CustomClassloader extends ClassLoader{

    private String classLoaderName;

    private String prefix ;

    public static final String suffix = ".class";

    public CustomClassloader(String classLoaderName){
        super();
        this.classLoaderName = classLoaderName;
    }

    public CustomClassloader(ClassLoader parent ,String classLoaderName){
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public CustomClassloader(ClassLoader parent){
        super(parent);
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("findClass invoke: "+name);
        System.out.println("class loader name: "+ classLoaderName);
        byte[] bytes = loadClassData(name);
        return this.defineClass(name, bytes ,0 ,bytes.length);
    }

    private byte[] loadClassData(String name){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        name = name.replace(".",File.separator);
        try{
            is = new FileInputStream(new File(this.prefix+name+suffix));
            baos = new ByteArrayOutputStream();

            int ch;

            while (-1 != (ch = is.read())){
                baos.write(ch);
            }
            data= baos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                is.close();
                baos.close();
            }catch (Exception ex){ex.printStackTrace();}
        }
        return data;
    }
}
