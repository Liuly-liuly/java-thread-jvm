package cn.designer.chapter3;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/27
 * @since JDK 1.8
 */
public class TestObserver extends QstlObserver {
    public TestObserver() {
        this(new Subject());
    }
    public TestObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void test() {
        super.test();
    }

}
