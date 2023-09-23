package com.hw3;

public class CreditCardNotificationApp {
    public static void main(String[] args) {
        // Create users
        User user1 = new User("Alice", "alice@email.com", "+1234567890");
        User user2 = new User("Bob", "bob@email.com", "+9876543210");

        // Initialize notification methods
        Notification emailNotification = new EmailNotification();
        Notification smsNotification = new SMSNotification();
        Notification whatsappNotification = new WhatsAppNotification();

        // Create a notification service
        NotificationService notificationService = new NotificationService();

        // Add users to the service
        notificationService.addUser(user1);
        notificationService.addUser(user2);

        // Set the notification method (e.g., email, SMS, WhatsApp)
        notificationService.setNotificationMethod(emailNotification);

        // Send notifications to all users
        notificationService.sendNotifications("Hey firstName, you have successfully registered for our credit card.");

        // Change notification method and send again (e.g., SMS)
        notificationService.setNotificationMethod(smsNotification);
        notificationService.sendNotifications("40% off when you buy Popeyes between 06/13 - 06/19");
    }
}