package com.pattern.publish_subscribe;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.attach(new WechatUser("jack"));
        subject.attach(new WechatUser("mary"));
        subject.attach(new WechatUser("Tom"));

        subject.notify("更新了");
    }
}
