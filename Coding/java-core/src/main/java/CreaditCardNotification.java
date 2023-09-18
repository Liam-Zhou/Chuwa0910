import java.util.HashMap;
import java.util.Map;

interface Notification {
    void sendNotification(String recipient, String message);
}

class EmailNotification implements Notification {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Sending email to " + recipient + ": " + message);
    }
}

class SMSNotification implements Notification {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Sending SMS to " + recipient + ": " + message);
    }
}

class WhatsAppNotification implements Notification {
    @Override
    public void sendNotification(String recipient, String message) {
        System.out.println("Sending WhatsApp message to " + recipient + ": " + message);
    }
}

class NotificationFactory {
    public Notification createNotification(String preference) {
        switch (preference) {
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

class NotificationService {
    private final NotificationFactory factory;
    private final Map<String, String> usersPreferences;

    public NotificationService() {
        this.factory = new NotificationFactory();
        this.usersPreferences = new HashMap<>();
    }

    public void addUser(String username, String preference) {
        usersPreferences.put(username, preference);
    }

    public void sendNotificationToUser(String username, String message) {
        String preference = usersPreferences.get(username);
        if (preference == null) {
            System.err.println("Error: User not found.");
            return;
        }

        try {
            Notification notification = factory.createNotification(preference);
            notification.sendNotification(username, message);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void sendPublicNotification(String message) {
        for (String userName : usersPreferences.keySet()) {
            sendNotificationToUser(userName, message);
            //usersMessages.put(userName, "By " + usersPreferences.get(userName) + ", " + userName + " have successfully received: " + message);
        }
    }
}

public class CreaditCardNotification {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();

        notificationService.addUser("user1", "email");
        notificationService.addUser("user2", "sms");
        notificationService.addUser("user3", "whatsapp");
        notificationService.addUser("user4", "phone");

        String publicMessage = "40% off when you buy Popeyes between 06/13 - 06/19";
        notificationService.sendPublicNotification(publicMessage);
    }
}

