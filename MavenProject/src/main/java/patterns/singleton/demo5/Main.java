package patterns.singleton.demo5;

import patterns.singleton.demo5.Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton ins1 = Singleton.getInstance();
        Singleton ins2 = Singleton.getInstance();
        System.out.println(ins1);
        System.out.println(ins2);
        System.out.println(ins1 == ins2);
    }
}
