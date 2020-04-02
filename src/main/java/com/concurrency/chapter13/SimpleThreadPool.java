package com.concurrency.chapter13;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/13
 * @since JDK 1.8
 */
public class SimpleThreadPool extends Thread {
    //有多少个线程在运行
    private int size;
    //一开始启动多少个线程
    private final int min;
    //任务队列多于min少于max 在启动几个出来
    private final int active;
    //最大开多少个
    private final int max;
    //能装多少个任务
    private final int queueSize;
    //任务大于queueSize策略是什么，默认放弃，丢掉
    private final DiscardPolicy discardPolicy;

    private final String PREFIX = "thread_Pool_";

    private volatile int seq = 0;

    private volatile Boolean destroy = false;

    private final ThreadGroup threadGroup = new ThreadGroup("ThreadPool");

    private static final DiscardPolicy DEFAULT_POLICY = () -> {
        throw new DiscardException("discard this task.....");
    };

    private final List<WorkTask> QUEUE_THREAD = new ArrayList<>();

    private final LinkedList<Runnable> QUEUE_TASK = new LinkedList<>();

    public SimpleThreadPool() {
        this(4, 8, 20, 45, DEFAULT_POLICY);
    }

    public SimpleThreadPool(int min, int active, int max, int queueSize, DiscardPolicy discardPolicy) {
        this.min = min;
        this.active = active;
        this.max = max;
        this.queueSize = queueSize;
        this.discardPolicy = discardPolicy;
        init();
    }

    public int getSize() {
        return size;
    }

    public int getMin() {
        return min;
    }

    public int getActive() {
        return active;
    }

    public int getMax() {
        return max;
    }

    public int getQueueSize() {
        return queueSize;
    }

    public Boolean getDestroy() {
        return destroy;
    }

    private void init() {
        for (int i = 0; i < min; i++) {
            createWork();
        }
        this.size = min;
        this.start();
    }

    private void createWork() {
        WorkTask workTask = new WorkTask(threadGroup, PREFIX + (seq++));
        workTask.start();
        QUEUE_THREAD.add(workTask);
    }


    public void submit(Runnable runnable) throws Exception {

        //如果线程池已经关闭就不让在提交任务，这个是重点
        if(destroy)
            throw new Exception("thread poll is shutdown...");

        if (runnable == null)
            return;

        synchronized (QUEUE_TASK) {
            if (QUEUE_TASK.size() >= queueSize) {
                discardPolicy.discard();
            }
            QUEUE_TASK.addLast(runnable);
            QUEUE_TASK.notifyAll();
        }

    }

    @Override
    public void run() {

        while (!destroy) { //这里主要就是维护线程池中的数量和状态

            System.out.printf("Pool#Min:%d,Active:%d,Max:%d,Current:%d,QueueSize:%d\n",
                        this.min, this.active, this.max, this.size, QUEUE_TASK.size());

            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int taskSize = QUEUE_TASK.size();

            if (taskSize > size && size < active) {
                for (int i = size; i < active; i++) {
                    createWork();
                }
                size = active;
            } else if (taskSize > size && size < max) {
                for (int i = size; i < max; i++) {
                    createWork();
                }
                size = max;
            }

            synchronized (QUEUE_THREAD) {
                if (QUEUE_TASK.isEmpty() && size > active) {//这里的作用很重要
                    System.out.println("=========Reduce========");
                    int release = size - active;
                    Iterator<WorkTask> iterator = QUEUE_THREAD.iterator();
                    while (iterator.hasNext() && release != 0) { //到这里线程基本上是属于blocked状态，阔以打断
                        WorkTask next = iterator.next();
                        next.close();
                        next.interrupt();
                        iterator.remove();
                        release--;
                    }
                    size = active;
                }
            }
        }
    }

    //关闭线程，需要的等待所有的任务都结束，任务队列为空载开始以结束所有的子线
    public void shutdown(){
        //首先检验发任务队列是否为空如果没有就让线程跑一会
        while( !QUEUE_TASK.isEmpty()){
            try {
                TimeUnit.SECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //然后开始把线程队列的每一个线程进行打断并先把状态置位终结
        synchronized (QUEUE_THREAD) {
            int initVal = QUEUE_THREAD.size();
            while (initVal > 0) {
                for (WorkTask task : QUEUE_THREAD) {
                    if (task.getWorkState() == WorkState.BLOCKED) {
                        task.close();
                        task.interrupt();
                        initVal--;
                    } else {
                        try {//这里是等待等到线程做完事情进入blocked状态
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        this.destroy = true;
        System.out.println("thread poll is shutdown......");
    }

    //现在立马结束
    public List shutdownNow(){
        List list = new LinkedList();
        synchronized (QUEUE_TASK){
            list.addAll(QUEUE_TASK);
            QUEUE_TASK.clear();
        }
        System.out.println("queue size :---->"+QUEUE_TASK.size());
        synchronized (QUEUE_THREAD){
            this.destroy = true;
            //这样做会出现问题，问题在于next.close 不会立即刷新到cpu 缓存中，而是过一阵子才阔以刷新进入
            //需要一定的时间才会刷入到cpu 缓存中
            //所以这里必须要有子线程的标记去打断所有线程
//            while (iterator.hasNext()){
//                WorkTask next = iterator.next();
//                System.out.println("====="+next.getName()+"===close");
//                next.close();
//                next.interrupt();
//                size--;
//            }

            while (!QUEUE_THREAD.isEmpty()){
                Iterator<WorkTask> iterator = QUEUE_THREAD.iterator();
                while (iterator.hasNext()){
                WorkTask next = iterator.next();
                if(next.workState == WorkState.BLOCKED){
                    next.interrupt();
                    next.close();
                    iterator.remove();
                    size--;
                }else {
                    try {
                        //这一步是尝试着去打断它 ，如果它可以打断就能运行到waiting
                        //然后根据标志位去真正的结束它
                        next.interrupt();
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            }
        }
        return list;
    }

    public static class DiscardException extends RuntimeException {
        public DiscardException(String message) {
            super(message);
        }
    }

    public interface DiscardPolicy {
        void discard() throws DiscardException;
    }

    public enum WorkState {
        TERMINATE, IDLE, RUNNING, BLOCKED, WAITING, TIME_WAITING
    }


    public class WorkTask extends Thread {

        private volatile WorkState workState = WorkState.IDLE;

        public WorkTask(ThreadGroup group, String name) {
            super(group, name);
        }

        public WorkState getWorkState() {
            return workState;
        }

        @Override
        public void run() {
            /*
             * 从任务队列获取任务，并释放锁。执行
             * 通过控制线程的状态去决定该线程是否结束，是不是要关闭该线程
             * 从而达到关闭等闲的线程，需要获取任务
             * */
            OUTER:
            while (this.workState != WorkState.TERMINATE) {
                Runnable inner = null;
                synchronized (QUEUE_TASK) {
                    while (QUEUE_TASK.isEmpty()) {
                        try {
                            workState = WorkState.BLOCKED;
                            QUEUE_TASK.wait();
                        } catch (InterruptedException e) {
                            System.out.println("interrupt....");
                            break OUTER;
                        }
                        //当所有的线程还未创建完成不会执行这里，坑！！！！
                        //System.out.println("--->get task");
                        //inner = QUEUE_TASK.removeFirst();
                    }

                    inner = QUEUE_TASK.removeFirst();
                }
                if (inner != null) {
                    workState = WorkState.RUNNING;
                    inner.run();
                    workState = WorkState.IDLE;
                }
            }

        }

        public void close() {
            this.workState = WorkState.TERMINATE;
        }
    }

    public static void main(String []args) throws Exception {
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool();
        Thread.sleep(1000);
        for (int i = 0; i < 50; i++) {
            simpleThreadPool.submit(() -> {
                System.out.println("The runnable  be serviced by " + Thread.currentThread() + " start.");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("The runnable be serviced by " + Thread.currentThread() + " finished.");
            });
        }

        //Thread.sleep(10000);
        //List list = simpleThreadPool.shutdownNow();
        //System.out.println("clear runnable--->"+list.size());
    }


}
