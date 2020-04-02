package cn.designer.chapter6;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/20
 * @since JDK 1.8
 */
public class AsynFuture<T> implements Future<T>{

    private T object;

    private volatile boolean done = false;

    public void done (T object){
        synchronized (this){
            done = true;
            this.object = object;
            notify();
        }
    }

    @Override
    public T get() throws InterruptedException {
        synchronized (this){
            while (!done){
                this.wait();
            }
            return object;
        }
    }
}
