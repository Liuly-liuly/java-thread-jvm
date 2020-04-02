package cn.designer.chapter3;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/15
 * @since JDK 1.8
 */
public abstract class Observer {

    protected Subject subject;

    public int i ;

    static Long l ;

    final double d = 0.00;

    public Observer(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void update();

     private void wqs(){
         System.out.println("this is wqs");
     }
}
