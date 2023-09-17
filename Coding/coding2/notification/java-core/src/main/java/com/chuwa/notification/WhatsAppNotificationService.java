package com.chuwa.notification;

public class WhatsAppNotificationService implements NotificationService {
    @Override
    public void sendNotification(User user, String message) {
        System.out.println("Sending WhatsApp message to " + user.getPhoneNumber() + ": " + message);
    }
}
