package cn.designer.chapter3;

import com.sun.corba.se.impl.orbutil.ObjectUtility;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/18
 * @since JDK 1.8
 */
public class ThreadLifeCycleListener implements LifeCycleListener {

    private Object LOCK = new Object();

    public void query(List<String>ids){

        ids.stream().forEach(i->new Thread( new ObservableRunnable(this){
            @Override
            public void run() {
                try {
                    notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                    System.out.println("query for the id " + i);
                    Thread.sleep(1000L);
                    notifyChange(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
                } catch (Exception e) {
                    notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));
                }
            }
        },i).start());
    }

    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {
        synchronized (LOCK){
            System.out.println("The runnable [" + event.getThread().getName() + "] data changed and state is [" + event.getState() + "]");
            if (event.getCause() != null) {
                System.out.println("The runnable [" + event.getThread().getName() + "] process failed.");
                event.getCause().printStackTrace();
            }
        }
    }

    @Override
    public void onClick(){

    }
}
