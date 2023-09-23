package com.hw3;

class WhatsAppNotification implements Notification {
    @Override
    public void sendNotification(User user, String message) {
        // Implement WhatsApp notification logic here
        System.out.println("Sending a WhatsApp message to " + user.getPhoneNumber() + ": " + message);
    }
}
