package com.chuwa.notification;

public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Sending Email to " + user.getEmail() + ": " + message);
    }
}
