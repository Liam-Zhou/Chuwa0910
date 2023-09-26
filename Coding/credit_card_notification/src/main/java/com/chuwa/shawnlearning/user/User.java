package com.chuwa.shawnlearning.user;

import com.chuwa.shawnlearning.notification.NotificationService;

public class User {
    private String firstName;
    private String email;
    private String phone;

    private final NotificationPreference preference;


    public User(String firstName, String email, String phone, NotificationPreference preference) {

        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.preference = preference;
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

    public NotificationPreference getPreference() {
        return preference;
    }
}
