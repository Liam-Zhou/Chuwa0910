package com.hw3;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private List<User> users;
    private Notification notificationMethod;

    public NotificationService() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void setNotificationMethod(Notification notificationMethod) {
        this.notificationMethod = notificationMethod;
    }

    public void sendNotifications(String message) {
        if (notificationMethod == null) {
            System.out.println("Error: Notification method not set.");
            return;
        }

        for (User user : users) {
            notificationMethod.sendNotification(user, message);
        }
    }
}
