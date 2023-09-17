package com.chuwa.notification;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User userA = new User();
        userA.setFirstName("John");
        userA.setNotificationPreference("EMAIL");
        userA.setEmail("john@example.com");

        User userB = new User();
        userB.setFirstName("Jane");
        userB.setNotificationPreference("EMAIL");
        userB.setEmail("jane@example.com");

        List<User> allUsers = new ArrayList<>();
        allUsers.add(userA);
        allUsers.add(userB);

        NotificationManager manager = new NotificationManager();
        manager.notifyUser(userA, "you have successfully registered.");

        // Broadcasting public notification to all users
        manager.broadcastNotification(allUsers, "40% off when you buy Popeyes between 06/13 - 06/19");
    }
}
