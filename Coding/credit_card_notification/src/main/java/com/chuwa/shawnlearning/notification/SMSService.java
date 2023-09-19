package com.chuwa.shawnlearning.notification;

import com.chuwa.shawnlearning.core.AnPaiZhiBo;
import com.chuwa.shawnlearning.exception.NotificationPreferenceNotMatched;
import com.chuwa.shawnlearning.user.NotificationPreference;
import com.chuwa.shawnlearning.user.User;

@AnPaiZhiBo
public class SMSService implements MessageTunnel {

    @Override
    public void send(String message, User user) throws NotificationPreferenceNotMatched {
        System.out.println("SMS sent: " + message);
        if(!user.getPreference().equals(NotificationPreference.SMS)){
            throw new NotificationPreferenceNotMatched("SMS Service " + user.getPreference() + " not matched");
        }
    }

    @Override
    public boolean support(NotificationPreference preference) {
        return true;
    }
}
