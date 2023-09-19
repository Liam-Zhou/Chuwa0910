package DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class PublisherSubscriber {
    public static void main(String[] args) {
        MessagePublisher publisher = new MessagePublisher();

        Observer subscriber1 = new MessageSubscriber("Subscriber 1");
        Observer subscriber2 = new MessageSubscriber("Subscriber 2");

        publisher.addObserver(subscriber1);
        publisher.addObserver(subscriber2);

        publisher.publishMessage("Hello, subscribers!");
    }
}


interface Observer {
    void update(String message);
}

interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

class MessagePublisher implements Observable {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void publishMessage(String message) {
        System.out.println("Publishing message: " + message);
        notifyObservers(message);
    }
}

class MessageSubscriber implements Observer {
    private String name;

    public MessageSubscriber(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}
