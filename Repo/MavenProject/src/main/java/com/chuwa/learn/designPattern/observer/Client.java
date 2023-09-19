package com.chuwa.learn.designPattern.observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.attach(new User("Francis"));
        subject.attach(new User("John"));
        subject.attach(new User("Andy"));

        subject.notify("new message!");
    }
}
