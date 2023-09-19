class SMSNotification implements NotificationStrategy {
    public void sendNotification(String message, User user) {
        System.out.println("Sending SMS to " + user.getPhoneNumber() + ": " + message);
    }
}