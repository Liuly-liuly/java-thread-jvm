package cn.designer.chapter4;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/20
 * @since JDK 1.8
 */
public class ShareData {

    private final char[] buf;

    private final ReadWriteLock lock = new ReadWriteLock();

    public ShareData(int size){
        buf = new char[size];
        for(int i = 0 ; i<size ; i++){
            buf[i]='*';
        }
    }

    public char[] read() throws InterruptedException {
        try{
            lock.readLock();
            return this.doRead();
        }finally {
            lock.readUnlock();
        }
    }

    public void write(char c) throws InterruptedException {
        try{
            lock.writeLock();
            this.doWrite(c);
        }finally {
            lock.writeUnlock();
        }
    }

    private void doWrite(char c) {
        for (int i = 0; i < buf.length; i++) {
            buf[i] = c;
            slowly(10);
        }
    }

    private char[] doRead() {
        char[]aux = new char[buf.length];
        for (int i =0 ; i<buf.length; i++){
            aux[i] = buf[i];
        }
        slowly(50);
        return aux;
    }

    private void slowly(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }

}
