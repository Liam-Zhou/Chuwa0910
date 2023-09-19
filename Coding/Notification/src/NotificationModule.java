import java.util.HashMap;
import java.util.Map;

class NotificationModule {
    private static Map<String, NotificationStrategy> strategies = new HashMap<>();

    static {
        strategies.put("EMAIL", new EmailNotification());
        strategies.put("SMS", new SMSNotification());
        strategies.put("WhatsAPP", new WhatsAppNotification());
    }

    public static void notifyUser(User user, String message) {
        NotificationStrategy strategy = strategies.get(user.getPreference());
        if (strategy == null) {
            throw new NotificationNotFoundException("Notification type " + user.getPreference() + " not found for user " + user.getFirstName());
        }
        strategy.sendNotification(message, user);
    }
}