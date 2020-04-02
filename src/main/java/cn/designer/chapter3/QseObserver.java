package cn.designer.chapter3;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/15
 * @since JDK 1.8
 */
public class QseObserver extends Observer {

    public QseObserver(Subject subject){
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("QseObserver String:" + Integer.toBinaryString(subject.getState()));
    }

}
