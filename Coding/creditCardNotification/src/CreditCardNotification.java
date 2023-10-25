// Notification interface
interface Notification {
    void sendNotification(String firstName, String content);
}

// Email notification implementation
class EmailNotification implements Notification {
    @Override
    public void sendNotification(String firstName, String content) {
        System.out.println("Sending email to " + firstName + ": " + content);
        // Implement email sending logic here
    }
}

// SMS notification implementation
class SMSNotification implements Notification {
    @Override
    public void sendNotification(String firstName, String content) {
        System.out.println("Sending SMS to " + firstName + ": " + content);
        // Implement SMS sending logic here
    }
}

// WhatsApp notification implementation
class WhatsAppNotification implements Notification {
    @Override
    public void sendNotification(String firstName, String content) {
        System.out.println("Sending WhatsApp message to " + firstName + ": " + content);
        // Implement WhatsApp sending logic here
    }
}

// Notification Factory
class NotificationFactory {
    public Notification createNotification(String preference) {
        switch (preference.toLowerCase()) {
            case "email":
                return new EmailNotification();
            case "sms":
                return new SMSNotification();
            case "whatsapp":
                return new WhatsAppNotification();
            default:
                throw new IllegalArgumentException("Invalid notification preference: " + preference);
        }
    }
}

public class CreditCardNotification {
    public static void main(String[] args) {
        // User's notification preference
        String userPreference = "email"; // Change this to test different preferences

        NotificationFactory notificationFactory = new NotificationFactory();
        try {
            // Create a notification object based on the user's preference
            Notification notification = notificationFactory.createNotification(userPreference);

            // User details
            String firstName = "John Doe";

            // Notification content
            String content = "Hey " + firstName + ", you have successfully registered for a credit card. " +
                    "Here is your card number: 1234-5678-9012-3456. " +
                    "Please use this for future references.";

            // Send the notification
            notification.sendNotification(firstName, content);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
