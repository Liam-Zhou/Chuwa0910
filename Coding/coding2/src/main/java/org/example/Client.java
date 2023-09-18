package org.example;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();
        subject.attach(new User("Francis", NotificationType.EMAIL));
        subject.attach(new User("John", NotificationType.WHATSAPP));
        subject.attach(new User("Andy", NotificationType.SMS));

        subject.notify("40% off when you buy Popeyes between 06/13 - 06/19");
    }
}
