package cn.designer.chapter3;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/18
 * @since JDK 1.8
 */
public class SubjectClient {

    public static void main(String[]args){
        Subject subject = new Subject();
        new QseObserver(subject);
        new QstlObserver(subject);
        System.out.println("==================");
        subject.setState(10);
        System.out.println("==================");
        subject.setState(10);

        System.out.println("==================");
        subject.setState(15);
    }
}
