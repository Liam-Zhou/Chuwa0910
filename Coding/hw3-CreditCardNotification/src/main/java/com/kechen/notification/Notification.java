package com.kechen.notification;

import com.kechen.observer.User;

public interface Notification {
    void sendNotification(User user);
}
