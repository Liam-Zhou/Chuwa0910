package com.kechen;

import com.kechen.notification.NotificationType;
import com.kechen.observer.User;
import com.kechen.subject.NotificationService;


public class Main {
    public static void main(String[] args) {
        User user1 = new User("Jack","jack@gmail.com", NotificationType.EMAIL);
        User user2 = new User("Mary","mary@gmail.com", NotificationType.SMS);
        User user3 = new User("Tom","tom@gmail.com", NotificationType.WHATSAPP);


        NotificationService notificationService = new NotificationService();

        notificationService.attach(user1);
        notificationService.sendNotificationToUser(user1);
        notificationService.attach(user2);
        notificationService.sendNotificationToUser(user2);
        notificationService.attach(user3);
        notificationService.sendNotificationToUser(user3);

        notificationService.broadcastPublicNotification("40% off when you buy Popeyes between 06/13 - 06/19");
    }
}