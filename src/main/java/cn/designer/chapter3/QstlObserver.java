package cn.designer.chapter3;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/15
 * @since JDK 1.8
 */
public class QstlObserver extends Observer {
    
    public QstlObserver(Subject subject){
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("QstlObserver String:" + Integer.toBinaryString(subject.getState()));
    }

    protected void test(){
        System.out.println("this is test");
    }

    private void kkTs(){
        System.out.println("---->kk ts cc");
    }
}
