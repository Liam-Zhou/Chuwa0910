import java.util.*;

// Define custom exceptions
class UnsupportedNotificationTypeException extends Exception {
    public UnsupportedNotificationTypeException(String message) {
        super(message);
    }
}

class NotificationSendFailedException extends Exception {
    public NotificationSendFailedException(String message) {
        super(message);
    }
}

interface NotificationStrategy {
    void sendNotification(String message, User user) throws NotificationSendFailedException;
}

class EmailNotification implements NotificationStrategy {
    @Override
    public void sendNotification(String message, User user) throws NotificationSendFailedException {
        try {
            // Here, you would have the actual logic to send an email.
            System.out.println("Sending EMAIL to " + user.getEmail() + " : " + message);
        } catch (Exception e) {
            throw new NotificationSendFailedException("Failed to send email to " + user.getEmail());
        }
    }
}

class SMSNotification implements NotificationStrategy {
    @Override
    public void sendNotification(String message, User user) throws NotificationSendFailedException {
        try {
            // Here, you would have the actual logic to send an SMS.
            System.out.println("Sending SMS to " + user.getPhone() + " : " + message);
        } catch (Exception e) {
            throw new NotificationSendFailedException("Failed to send SMS to " + user.getPhone());
        }
    }
}

class WhatsAppNotification implements NotificationStrategy {
    @Override
    public void sendNotification(String message, User user) throws NotificationSendFailedException {
        try {
            // Here, you would have the actual logic to send a WhatsApp message.
            System.out.println("Sending WhatsApp message to " + user.getPhone() + " : " + message);
        } catch (Exception e) {
            throw new NotificationSendFailedException("Failed to send WhatsApp message to " + user.getPhone());
        }
    }
}

class User {
    private String firstName;
    private String email;
    private String phone;
    private NotificationStrategy preference;

    public User(String firstName, String email, String phone) {
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public NotificationStrategy getPreference() {
        return preference;
    }

    public void setPreference(NotificationStrategy preference) throws UnsupportedNotificationTypeException {
        if (!(preference instanceof EmailNotification) && !(preference instanceof SMSNotification) && !(preference instanceof WhatsAppNotification)) {
            throw new UnsupportedNotificationTypeException("Unsupported notification type");
        }
        this.preference = preference;
    }
}

class NotificationService {
    public void notifyUser(User user, String content) {
        try {
            user.getPreference().sendNotification(content, user);
        } catch (NotificationSendFailedException e) {
            e.printStackTrace();
        }
    }

    public void broadcastPublicNotification(String content, List<User> users) {
        for (User user : users) {
            try {
                user.getPreference().sendNotification(content, user);
            } catch (NotificationSendFailedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class CreditCard {
    public static void main(String[] args) {
        try {
            User userA = new User("John", "john@example.com", "1234567890");
            userA.setPreference(new EmailNotification());

            User userB = new User("Jane", "jane@example.com", "0987654321");
            userB.setPreference(new SMSNotification());

            NotificationService notificationService = new NotificationService();

            // Personal notification
            String personalMessage = "Hey " + userA.getFirstName() + ", you have successfully registered to add and here is your, please use this for future references.";
            notificationService.notifyUser(userA, personalMessage);

            // Broadcast notification
            List<User> allUsers = Arrays.asList(userA, userB);
            String broadcastMessage = "40% off when you buy Popeyes between 06/13 - 06/19";
            notificationService.broadcastPublicNotification(broadcastMessage, allUsers);
        } catch (UnsupportedNotificationTypeException e) {
            e.printStackTrace();
        }
    }
}

