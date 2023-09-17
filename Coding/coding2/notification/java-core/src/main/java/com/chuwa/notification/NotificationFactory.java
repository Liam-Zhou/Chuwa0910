package com.chuwa.notification;

public class NotificationFactory {
    public static NotificationService getNotificationService(String preference) {
        switch (preference.toUpperCase()) {
            case "EMAIL":
                return new EmailNotificationService();
            case "SMS":
                return new SMSNotificationService();
            case "WHATSAPP":
                return new WhatsAppNotificationService();
            default:
                throw new UnsupportedOperationException("Notification preference " + preference + " not supported.");
        }
    }
}

