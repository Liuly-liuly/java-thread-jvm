package cn.designer.chapter4;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/19
 * @since JDK 1.8
 */
public class ReadWriteLock {

    private int readingWorks = 0;

    private int writingWorks = 0;

    private int waitingReaders = 0;

    private int waitingWriters = 0;

    private boolean preferWrite = true;


    public ReadWriteLock(){
        this(true);
    }

    public ReadWriteLock(Boolean preferWrite){
        this.preferWrite = preferWrite;
    }

    public synchronized void readLock() throws InterruptedException {
        waitingReaders++;
        try{
            //如果处于waiting 状态阔以打断
            while (writingWorks>0|| (preferWrite && waitingWriters>0)){
                this.wait();
            }
            readingWorks++;
        }finally {
            waitingReaders--;
        }
    }

    public synchronized void readUnlock(){
        readingWorks--;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;
        try{
            while (readingWorks>0 || writingWorks>0){
                this.wait();
            }
            writingWorks++;
        }finally {
            waitingWriters--;
        }
    }

    public synchronized void writeUnlock(){
        writingWorks--;
        notifyAll();
    }

}
