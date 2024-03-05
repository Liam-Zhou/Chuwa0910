package DesignPattern.Singleton;

public class Singleton {
    // Eager Load
    private Singleton() {}
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    };
}
