package cn.designer.chapter6;

import java.util.function.Consumer;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/20
 * @since JDK 1.8
 */
public class FutureService {

    public <T> Future<T> submit(FutureTask<T> task){
        AsynFuture<T> tAsynFuture = new AsynFuture<>();
        new Thread(()->{
            T call = task.call();
            tAsynFuture.done(call);
        }).start();
        return tAsynFuture;
    }

    public <T> Future<T> submit(FutureTask<T> task , Consumer<T> consumer){
        AsynFuture<T> tAsynFuture = new AsynFuture<>();
        new Thread(()->{
            T call = task.call();
            tAsynFuture.done(call);
            consumer.accept(call);
        }).start();
        return tAsynFuture;
    }
}
