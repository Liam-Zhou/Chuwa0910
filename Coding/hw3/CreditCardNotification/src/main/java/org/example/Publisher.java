package org.example;

import org.example.USER.abUser;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private UserBuilder builder;
    private List<abUser> subList;

    public Publisher(UserBuilder builder) {
        this.builder = builder;
        this.subList = new ArrayList<>();
    }

    public boolean register(String name, String type, String contact, String email){
        try{
            abUser user = builder.userBuild(name,type,email,contact);
            this.subList.add(user);
            user.RegisterNote(name);
            return true;
        } catch(Exception e) {
            System.out.println("Failure on register");
        }
        return false;
    }

    public void noteAll(String message){
        subList.forEach((user)-> user.note(message));
    }
}
