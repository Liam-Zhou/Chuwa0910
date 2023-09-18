package org.example;

import org.example.pattern.DirectorBuilder.BuilderTyA;
import org.example.pattern.DirectorBuilder.Director;
import org.example.pattern.FactoryObject.OGobject;
import org.example.pattern.PublisherSubscriber.Publisher;
import org.example.pattern.PublisherSubscriber.Subscriber;
import org.example.pattern.SimpleFactory;
import org.example.pattern.SingletonDynamic;
import org.example.pattern.SingletonLazy;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Singleton-Dynamic");
        SingletonDynamic instance1 = SingletonDynamic.getInstance();
        SingletonDynamic instance2 = SingletonDynamic.getInstance();
        System.out.println(instance1 == instance2);

        System.out.println("Singleton-lazy");
        SingletonLazy ins1 = SingletonLazy.getInstance();
        SingletonLazy ins2 = SingletonLazy.getInstance();
        System.out.println(ins1 == ins2);

        System.out.println("Factory");
        SimpleFactory SF = new SimpleFactory();
        try{
            OGobject ob1 = SF.getObject("object1");
            OGobject ob2 = SF.getObject("object2");
        } catch (Exception e) {
            System.out.println("Cannot find the object");
        }

        System.out.println("Builder");
        Director director = new Director(new BuilderTyA());
        director.build();

        System.out.println("Publisher && Subscriber");
        Publisher pub = new Publisher();
        pub.add(new Subscriber());
        pub.notifySubs();
    }
}