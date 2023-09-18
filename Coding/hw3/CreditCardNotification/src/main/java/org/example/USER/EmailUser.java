package org.example.USER;

public class EmailUser extends abUser{

    public EmailUser(String user,String email) {
        super.user = user;
        super.PreferType = "Email";
        super.Email = email;
    }
    @Override
    public void note(String message) {
        System.out.println("Email notification: "+ message);
    }
}
