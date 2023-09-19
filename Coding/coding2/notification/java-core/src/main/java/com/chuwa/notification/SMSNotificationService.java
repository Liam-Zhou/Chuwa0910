package com.chuwa.notification;

public class SMSNotificationService implements NotificationService {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Sending SMS to " + user.getPhoneNumber() + ": " + message);
    }
}
