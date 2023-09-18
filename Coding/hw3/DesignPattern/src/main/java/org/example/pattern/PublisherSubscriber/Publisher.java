package org.example.pattern.PublisherSubscriber;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<Subscriber> subList;

    public Publisher() {
        this.subList = new ArrayList<>();
    }

    public void add(Subscriber a) {}

    public Boolean detach(Subscriber a) {return true;}

    public void notifySubs(){
        subList.forEach((fan)->fan.update("xxx"));
    }
}
