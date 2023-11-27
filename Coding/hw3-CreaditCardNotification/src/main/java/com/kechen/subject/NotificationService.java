package com.kechen.subject;

import com.kechen.notification.*;
import com.kechen.observer.User;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private final Notification emailNotification;
    private final Notification smsNotification;
    private final Notification whatsappNotification;

    private List<User> userList;

    public NotificationService() {
        emailNotification = new EmailNotification();
        smsNotification = new SmsNotification();
        whatsappNotification = new WhatsappNotification();
        userList = new ArrayList<>();
    }

    public void attach(User user){
        userList.add(user);
    }

    public void sendNotificationToUser(User user){
        NotificationType preference = user.getNotificationPerference();

        switch(preference){
            case EMAIL:
                emailNotification.sendNotification(user);
                break;
            case SMS:
                smsNotification.sendNotification(user);
                break;
            case WHATSAPP:
                whatsappNotification.sendNotification(user);
                break;
            default:
                System.out.println("Invalid notification preference for user " + user.getFirstName());
        }
    }

    public void broadcastPublicNotification(String message){
        for(User user:userList){
            System.out.println(user.getFirstName() + ", " + message);
        }
    }
}
