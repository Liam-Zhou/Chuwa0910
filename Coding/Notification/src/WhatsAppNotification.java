class WhatsAppNotification implements NotificationStrategy {
    public void sendNotification(String message, User user) {
        System.out.println("Sending WhatsApp message to " + user.getPhoneNumber() + ": " + message);
    }
}