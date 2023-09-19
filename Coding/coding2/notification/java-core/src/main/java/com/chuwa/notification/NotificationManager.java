package com.chuwa.notification;

import java.util.List;

public class NotificationManager {
    public void notifyUser(User user, String content) {
        try {
            NotificationService service = NotificationFactory.getNotificationService(user.getNotificationPreference());
            String message = "Hey " + user.getFirstName() + ", " + content;
            service.sendNotification(user, message);
        } catch (UnsupportedOperationException e) {
            System.err.println(e.getMessage());
        }
    }

    public void broadcastNotification(List<User> users, String content) {
        for (User user : users) {
            notifyUser(user, content);
        }
    }
}

