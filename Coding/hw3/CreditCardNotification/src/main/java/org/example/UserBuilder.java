package org.example;

import org.example.USER.EmailUser;
import org.example.USER.SMSUser;
import org.example.USER.abUser;

public class UserBuilder {
    public abUser userBuild(String name, String type, String email, String contact) throws Exception {
        if(type.equals("SMS")) {
            return new SMSUser(name,email,contact);
        }
        else if(type.equals("Email")) {
            return new EmailUser(name,email);
        }
        else {
            throw new Exception("Wrong type User");
        }
    }
}
