package com.pattern.publish_subscribe;

import java.util.ArrayList;
import java.util.List;

//具体主题角色类
public class SubscriptionSubject implements Subject{

    //定义一个集合，存储多个观察者对象
    private List<Observer> wechatUserList = new ArrayList<>();
        @Override
    public void attach(Observer observer) {
        wechatUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        wechatUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for(Observer observer : wechatUserList){
            observer.update(message);
        }
    }
}
