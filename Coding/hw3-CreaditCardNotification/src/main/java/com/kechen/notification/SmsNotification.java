package com.kechen.notification;

import com.kechen.observer.User;

public class SmsNotification implements Notification {
    @Override
    public void sendNotification(User user) {
        System.out.println("Hey," + user.getFirstName()  + " " + "you have successfully registered to add and here is your" +
                "please use this for future references.");
    }
}
