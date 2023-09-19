package com.chuwa.notification;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String notificationPreference; // can be EMAIL, SMS, WHATSAPP

    // getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getNotificationPreference() {
        return notificationPreference;
    }

    // setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setNotificationPreference(String notificationPreference) {
        this.notificationPreference = notificationPreference;
    }
}

