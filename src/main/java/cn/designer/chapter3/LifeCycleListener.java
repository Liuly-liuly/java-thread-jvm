package cn.designer.chapter3;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/15
 * @since JDK 1.8
 */
public interface LifeCycleListener {

     static int i =0;
     String s = "str";
     final TestObserver o = new TestObserver();

     void onEvent(ObservableRunnable.RunnableEvent event);

     default void onClick(){
          System.out.println("this id interface method body");
     }

     static void onSave(){
          System.out.println("this is interface method on save");
     }
}
