package DesignPattern.Observer;

/**
 * @Description:
 * @Author: hyc
 */
public class Client {
    public static void main(String[] args) {
        // 公众号主体
        SubscriptionSubject subject = new SubscriptionSubject();

        // 订阅公众号
        subject.add(new WechatUser("John"));
        subject.add(new WechatUser("Michael"));
        subject.add(new WechatUser("Leon"));

        // 更新公众号
        subject.notify("Updated Message!");
    }
}
