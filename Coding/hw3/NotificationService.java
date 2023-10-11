interface NotificationStrategy {
    void notify(User user, String content);
}

class EmailNotification implements NotificationStrategy {
    @Override
    public void notify(User user, String content) {
        System.out.println("Sending email to " + user.getEmail() + ": " + content);
    }
}

class SMSNotification implements NotificationStrategy {
    @Override
    public void notify(User user, String content) {
        System.out.println("Sending SMS to " + user.getPhoneNumber() + ": " + content);
    }
}

class WhatsAppNotification implements NotificationStrategy {
    @Override
    public void notify(User user, String content) {
        System.out.println("Sending WhatsApp message to " + user.getPhoneNumber() + ": " + content);
    }
}

class NotificationFactory {
    public static NotificationStrategy getNotificationMethod(String preference) {
        switch (preference) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "WHATSAPP":
                return new WhatsAppNotification();
            default:
                throw new IllegalArgumentException("Invalid notification preference");
        }
    }
}

class User {
    private String firstName;
    private String email;
    private String phoneNumber;
    private String notificationPreference;


    public void notifyUser(String content) {
        NotificationStrategy strategy = NotificationFactory.getNotificationMethod(notificationPreference);
        strategy.notify(this, content);
    }
}

public class NotificationService {
    public static void main(String[] args) {
        User userA = new User();
        userA.setFirstName("John");
        userA.setEmail("john@example.com");
        userA.setPhoneNumber("1234567890");
        userA.setNotificationPreference("EMAIL");

        String content = "Hey " + userA.getFirstName() + ", you have successfully registered to our service, please use this for future references.";

        userA.notifyUser(content);

        // For broadcasting
        String broadcastContent = "40% off when you buy Popeyes between 06/13 - 06/20!";
        // Fetch all users from the database and then:
        // for(User user : allUsers) {
        //     user.notifyUser(broadcastContent);
        // }
    }
}
