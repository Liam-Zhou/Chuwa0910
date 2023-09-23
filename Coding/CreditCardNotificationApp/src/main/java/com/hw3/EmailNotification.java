package com.hw3;

public class EmailNotification implements Notification{
    @Override
    public void sendNotification(User user, String message) {
        // Implement email notification logic here
        System.out.println("Sending an email to " + user.getEmail() + ": " + message);
    }
}
