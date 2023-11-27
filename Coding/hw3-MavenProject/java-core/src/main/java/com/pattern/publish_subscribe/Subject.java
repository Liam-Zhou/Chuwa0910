package com.pattern.publish_subscribe;

public interface Subject {

    //添加订阅者（添加观察者对象）
    void attach(Observer observer);

    void detach(Observer observer);

    void notify(String message);
}
