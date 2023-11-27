package com.kechen.observer;

import com.kechen.notification.NotificationType;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String email;
    private NotificationType notificationPerference;

    public User(String firstName, String email, NotificationType notificationPerference) {
        this.firstName = firstName;
        this.email = email;
        this.notificationPerference = notificationPerference;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NotificationType getNotificationPerference() {
        return notificationPerference;
    }

}
