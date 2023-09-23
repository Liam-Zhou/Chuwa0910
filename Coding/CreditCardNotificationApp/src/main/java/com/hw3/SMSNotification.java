package com.hw3;

public class SMSNotification implements Notification {
    @Override
    public void sendNotification(User user, String message) {
        // Implement SMS notification logic here
        System.out.println("Sending an SMS to " + user.getPhoneNumber() + ": " + message);
    }
}