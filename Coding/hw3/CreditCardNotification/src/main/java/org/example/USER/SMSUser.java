package org.example.USER;

public class SMSUser extends abUser{
    public SMSUser(String user,String email, String SMS) {
        super.user = user;
        super.PreferType = "SMS";
        super.Email = email;
        super.SMS = SMS;
    }

    @Override
    public void note(String message) {
        System.out.println("SMS notification: " + message);
    }
}
