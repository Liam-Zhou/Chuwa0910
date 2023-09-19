package com.chuwa.homework.hw3.design;
import java.util.HashMap;
import java.util.Map;

// Notification interface
interface Notification {
    void sendNotification(String firstName, String message);
}

// Email notification preference
class EmailNotification implements Notification {
    @Override
    public void sendNotification(String firstName, String message) {
        // Implement email notification logic here
        System.out.println("Sending email to " + firstName + ": " + message);
    }
}

// SMS notification preference
class SMSNotification implements Notification {
    @Override
    public void sendNotification(String firstName, String message) {
        // Implement SMS notification logic here
        System.out.println("Sending SMS to " + firstName + ": " + message);
    }
}

// WhatsApp notification preference
class WhatsAppNotification implements Notification {
    @Override
    public void sendNotification(String firstName, String message) {
        // Implement WhatsApp notification logic here
        System.out.println("Sending WhatsApp message to " + firstName + ": " + message);
    }
}

// NotificationController to handle notification preferences and errors
class NotificationController {
    private Map<String, Notification> preferences;

    public NotificationController() {
        preferences = new HashMap<>();
    }

    public void setNotificationPreference(String username, Notification preference) {
        preferences.put(username, preference);
    }

    public void sendNotificationToUser(String username, String firstName, String message) {
        Notification preference = preferences.get(username);
        if (preference != null) {
            preference.sendNotification(firstName, message);
        } else {
            System.err.println("Error: Notification preference not found for " + username);
        }
    }
}

public class CreditCardNotification {
    public static void main(String[] args) {
        NotificationController notificationManager = new NotificationController();

        // Set notification preferences for users
        notificationManager.setNotificationPreference("UserA", new EmailNotification());
        notificationManager.setNotificationPreference("UserB", new SMSNotification());
        notificationManager.setNotificationPreference("UserC", new WhatsAppNotification());

        // Example notifications
        notificationManager.sendNotificationToUser("UserA", "FirstA", "Hey FirstA, you have successfully registered to add and here is your , please use this for \n" +
                "future references.");
        notificationManager.sendNotificationToUser("UserB", "FirstB", "Hey FirstB, you have successfully registered to add and here is your , please use this for \n" +
                "future references.");
        notificationManager.sendNotificationToUser("UserD", "FirstC", "Hey FirstC, you have successfully registered to add and here is your , please use this for \n" +
                "future references.");

        // Broadcast public notification
        String publicMessage = "40% off when you buy Popeyes between 06/13 - 06/19";
        notificationManager.sendNotificationToUser("UserA", "FirstA", publicMessage);
        notificationManager.sendNotificationToUser("UserB", "FirstB", publicMessage);
        notificationManager.sendNotificationToUser("UserC", "FirstC", publicMessage);
    }
}
