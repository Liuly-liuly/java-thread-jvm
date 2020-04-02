package cn.designer.chapter4;

import java.util.Random;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/20
 * @since JDK 1.8
 */
public class WriteWork extends Thread {

    private static final Random random = new Random(System.currentTimeMillis());

    private final ShareData data;

    private final String filler;

    private int index = 0;

    public WriteWork(ShareData data, String filler) {
        this.data = data;
        this.filler = filler;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char c = nextChar();
                data.write(c);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() {
        char c = filler.charAt(index);
        index++;
        if (index >= filler.length())
            index = 0;
        return c;
    }

}
