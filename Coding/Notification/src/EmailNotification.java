public class EmailNotification implements NotificationStrategy {
    public void sendNotification(String message, User user) {
        System.out.println("Sending email to " + user.getEmail() + ": " + message);
    }
}