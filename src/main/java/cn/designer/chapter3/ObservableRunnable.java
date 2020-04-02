package cn.designer.chapter3;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/15
 * @since JDK 1.8
 */
public abstract class ObservableRunnable implements Runnable{

    protected final LifeCycleListener listener;

    protected ObservableRunnable(LifeCycleListener listener) {
        this.listener = listener;
    }

    protected void notifyChange(RunnableEvent event){
        listener.onEvent(event);
    }

    public enum RunnableState{
        RUNNING, ERROR, DONE;
    }

    public class RunnableEvent{
        private final RunnableState state;
        private final Thread thread;
        private final Throwable cause;

        public RunnableEvent(RunnableState state, Thread thread, Throwable cause) {
            this.state = state;
            this.thread = thread;
            this.cause = cause;
        }

        public RunnableState getState() {
            return state;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return cause;
        }
    }

}
