package cn.designer.chapter3;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description: 1367636569@qq.com
 * @Auther: Liuly
 * @Date: 2019/11/15
 * @since JDK 1.8
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state){

        if(this.state == state)
            return;
        this.state = state;

        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        observers.stream().forEach(Observer::update);
    }


}
