package patterns.publish_subscriber;

public class Main {
    public static void main(String[] args) {
        Subject subject = new SubscriptionSubject();
        WeixinUser first = new WeixinUser("Wukong");
        WeixinUser second = new WeixinUser("Wuneng");
        WeixinUser third = new WeixinUser("Wujing");

        subject.attach(first);
        subject.attach(second);
        subject.attach(third);

        subject.notify("Welcome to this channel!");
        subject.detach(first);
        subject.notify("Welcome to this channel!");
    }
}
