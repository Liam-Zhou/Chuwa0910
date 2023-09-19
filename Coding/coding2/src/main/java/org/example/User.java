package org.example;

public class User implements Observer {

    private String name;
    private NotificationType type;

    public User(String name, NotificationType type) {
        this.name = name;
        this.type = type;
        String welcomeMessage = " ,you have successfully registered to add and here is your , please use this for future references";
        System.out.println("Hey "+name+welcomeMessage);
    }


    @Override
    public void update(String message) {
        if (type == NotificationType.EMAIL) System.out.println(name + " get Email says: " + message);
        else if (type == NotificationType.SMS) System.out.println(name + " get Sms says: " + message);
        else if (type == NotificationType.WHATSAPP) System.out.println(name + " get Whatsapp says: " + message);
    }
}
