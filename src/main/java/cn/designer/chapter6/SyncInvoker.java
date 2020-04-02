package cn.designer.chapter6;

/***************************************
 * @author:Alex Wang
 * @Date:2017/3/22 QQ:532500648
 * QQ交流群:286081824
 ***************************************/

import sun.rmi.log.LogInputStream;

import java.util.ArrayList;
import java.util.List;

/**
 * Future        ->代表的是未来的一个凭据
 * FutureTask    ->将你的调用逻辑进行了隔离
 * FutureService ->桥接 Future和 FutureTask
 */
public class SyncInvoker {

    public static void main(String[] args) throws InterruptedException {
        /*String result = get();
        System.out.println(result);*/

        FutureService futureService = new FutureService();
//        futureService.submit(() -> {
//            try {
//                Thread.sleep(1000l);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "FINISH";
//        }, System.out::println);

        Future<ArrayList<Object>> submit = futureService.submit(() -> {
            ArrayList<Object> objects = new ArrayList<>();
            try {
                Thread.sleep(1000);
                objects.add("123");
                objects.add("345");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return objects;
        }, new SyncInvoker()::printData);

        System.out.println("===========");
        System.out.println(" do other thing.");
        Thread.sleep(1000);
        System.out.println("===========");
    }

    public void printData(List<?> list) {
        list.stream().forEach(System.out::println);
    }
}