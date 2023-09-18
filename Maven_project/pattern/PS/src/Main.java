public class Main {
    public static void main(String[] args) {
        Subject subject = new SubscriptionSubject();
        WexinUser first = new WexinUser("Wukong");
        WexinUser second = new WexinUser("Wuneng");
        WexinUser third = new WexinUser("Wujing");
        subject.attach(first);
        subject.attach(second);
        subject.attach(third);
        subject.detach(first);
        subject.notify("Welcome to this channel!");
    }
}