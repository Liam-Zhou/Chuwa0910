package com.chuwa.shawnlearning.notification;

import com.chuwa.shawnlearning.exception.NotificationPreferenceNotMatched;
import com.chuwa.shawnlearning.user.NotificationPreference;
import com.chuwa.shawnlearning.user.User;

import java.util.prefs.Preferences;

public interface MessageTunnel {
    void send(String message, User user) throws NotificationPreferenceNotMatched;

    boolean support(NotificationPreference preference);
}
