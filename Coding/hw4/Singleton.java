package homework.hw4;

public class Singleton {
    private static class InstanceHolder {
        private static final Singleton instance = new Singleton();
    }

    private static Singleton instance = new Singleton();
    private Singleton() {}

    public static Singleton getEagerInstance() {
        return instance;
    }

    public static Singleton getLazyInstance() {
        return InstanceHolder.instance;
    }
}
