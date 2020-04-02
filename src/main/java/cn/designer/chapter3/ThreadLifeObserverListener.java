package cn.designer.chapter3;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/18
 * @since JDK 1.8
 */
public class ThreadLifeObserverListener extends ObservableRunnable {

    public ThreadLifeObserverListener(LifeCycleListener listener) {
        super(listener);
    }

    @Override
    public void run() {

    }
}
